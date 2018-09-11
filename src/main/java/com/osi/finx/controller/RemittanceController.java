package com.osi.finx.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osi.finx.exception.FinXTransactionException;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.model.QxmaFtRemittance;
import com.osi.finx.model.RemittanceView;
import com.osi.finx.service.RemittanceService;
import com.osi.finx.utils.RemitCounter;
import com.osi.finx.utils.RemittanceConverter;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RemittanceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemittanceController.class);
	
	@Autowired
	private RemittanceService remittanceService;
	
	@PostMapping(value="/upload", consumes = "multipart/form-data")
	public void uploadRemittanceFile(@RequestParam("file") MultipartFile multipartFile) {
		LOGGER.debug("RemittanceController :: uploadRemittanceFile :: START");
		try {
			//int count = countTransactionsInFile(multipartFile.getInputStream());
			processRemittanceFile(multipartFile.getInputStream());

		} catch (IOException e) {
			LOGGER.error("RemittanceController :: uploadRemittanceFile :: ERROR :: ", e);
			LOGGER.debug("RemittanceController :: uploadRemittanceFile :: END");
		}
	}
	
	private int countTransactionsInFile(InputStream inputStream) {
		RemitCounter rc = new RemitCounter(inputStream);
		rc.run();
		int count = rc.getRecordCount();
		return count;
	}
	
	/**
	 *   	
	 *  check remittance against charges to find the Order_id (payload_id)
				//when the Order_id is located in the charges table, get the Order Id
				//using the Order id, locate the Order id in Remittance table if it exists.
				//If it does exist:
				// update the charge table - charge_status = remitted, compare charges.total_amount against remittance.amount_deposited. if
				// if charges.total_amount > remittance.amount_deposited = charge.match_status = under_remit
				//if charges.total_amount < remittance.amount_deposited = charge.match_status = over_remit
				//if charges.total_amount == remittance.amount_deposited = charge.match_status = match
	 */
	private void processRemittanceTransactions(QxmaFtRemittance remittance) {
		LOGGER.debug("RemittanceController :: processRemittanceTransactions :: START");
		try {
			remittanceService.createRemittanceTransaction(remittance);
		} catch (FinXTransactionException e) {
			
		} catch (OsiFinderException e) {
			LOGGER.error("RemittanceController :: processRemittanceTransactions :: ERROR ", e);
			LOGGER.debug("RemittanceController :: processRemittanceTransactions :: END");
		}
		LOGGER.debug("RemittanceController :: processRemittanceTransactions :: END");
	}
	
	
	private List<String> processRemittanceFile(InputStream inputStream) {
		LOGGER.debug("RemittanceController :: processRemittanceFile :: START");
		ArrayList<String> bankReferences = new ArrayList<String>();
		Scanner scanner = null;
		int lineCount = 0;
		String bankReferenceNo = null;
		try {
			scanner = new Scanner(inputStream, "UTF-8");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println("line : " + line);
				if (lineCount == 0) {
					lineCount++;
					continue;
				}
				QxmaFtRemittance qfr = RemittanceConverter.convertCSVItemToRemittance(line);
				bankReferenceNo = remittanceService.findRemittanceBankReference(qfr.getBankRef());
				if (bankReferenceNo != null) {
					bankReferences.add(bankReferenceNo);
					continue;
				}
				
				this.processRemittanceTransactions(qfr);
				
			}
			if (scanner.ioException() != null) {
				LOGGER.error("RemittanceController :: processRemittanceFile :: ERROR :: ", scanner.ioException().getCause());
				LOGGER.debug("RemittanceController :: processRemittanceFile :: END");
				throw scanner.ioException();
			}
		} catch (FileNotFoundException e) {
			LOGGER.error("RemittanceController :: processRemittanceFile :: ERROR :: ", e);
			LOGGER.debug("RemittanceController :: processRemittanceFile :: END");
		} catch (IOException ioe) {
			LOGGER.error("RemittanceController :: processRemittanceFile :: ERROR :: ", ioe);
			LOGGER.debug("RemittanceController :: processRemittanceFile :: END");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		return bankReferences;
	}
	
	@GetMapping("/remittances")
	public ResponseEntity<Page<QxmaFtRemittance>> getRemittancePage(@PathVariable Pageable pageable) {
		Page<QxmaFtRemittance> page = remittanceService.findRemittances(pageable);
		ResponseEntity<Page<QxmaFtRemittance>> response = new ResponseEntity<Page<QxmaFtRemittance>>(page, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(value="/findByOrderStatus/{orderStatus}", params = {"page", "size"})
	public ResponseEntity<List<RemittanceView>> findRemittanceByOrderStatus(@PathVariable String orderStatus, 
																													  @RequestParam("page") int page, 
																													  @RequestParam("size") int size) {
		LOGGER.debug("RemittanceController :: findRemittanceByOrderStatus :: START");
		LOGGER.debug("RemittanceController :: findRemittanceByOrderStatus :: orderStatus = " + orderStatus + ", page = " + page + ", size = " + size);
		List<RemittanceView> list = remittanceService.findByOrderStatus(orderStatus, PageRequest.of(page, size));
		ResponseEntity<List<RemittanceView>> response = new ResponseEntity<List<RemittanceView>>(list, HttpStatus.OK);
		LOGGER.debug("RemittanceController :: findRemittanceByOrderStatus :: END");
		return response;
	}
	
	@GetMapping(value="/findByMatchStatus/{matchStatus}", params = {"page", "size"})
	public ResponseEntity <List<RemittanceView>> findRemittanceByMatchStatus(@PathVariable String matchStatus,
																													   @RequestParam("page") int page, 
																													   @RequestParam("size") int size) {
		LOGGER.debug("RemittanceController :: findRemittanceByMatchStatus :: START");
		LOGGER.debug("RemittanceController :: findRemittanceByMatchStatus :: matchStatus = " + matchStatus + ", page = " + page + ", size = " + size);
		List<RemittanceView> list = remittanceService.findByMatchStatus(matchStatus, PageRequest.of(page, size));
		ResponseEntity<List<RemittanceView>> response = new ResponseEntity<List<RemittanceView>>(list, HttpStatus.OK);
		LOGGER.debug("RemittanceController :: findRemittanceByMatchStatus :: END");
		return response;
	}
	
	@GetMapping(value="/findByClient/{client}", params = {"page", "size"})
	public ResponseEntity<List<RemittanceView>> findRemittanceByClient(@PathVariable String client, 
																											@RequestParam("page") int page, 
																											@RequestParam("size") int size) {
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: START");
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: client = " + client + ", page = " + page + ", size = " + size);

		List<RemittanceView> list = remittanceService.findByClient(client, PageRequest.of(page, size));
		ResponseEntity<List<RemittanceView>> response = new ResponseEntity<List<RemittanceView>>(list, HttpStatus.OK);
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: END");
		return response;
	}
	
	@GetMapping(value="/findByPaymentProcessor/{processor}", params = {"page", "size"})
	public ResponseEntity<List<RemittanceView>> findRemittanceByPaymentProcessor(@PathVariable String processor, 
																											@RequestParam("page") int page, 
																											@RequestParam("size") int size) {
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: START");
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: client = " + processor + ", page = " + page + ", size = " + size);

		List<RemittanceView> list = remittanceService.findByPaymentProcessor(processor, PageRequest.of(page, size));
		ResponseEntity<List<RemittanceView>> response = new ResponseEntity<List<RemittanceView>>(list, HttpStatus.OK);
		LOGGER.debug("RemittanceController :: findRemittanceByClient :: END");
		return response;
		
	}
	
}
