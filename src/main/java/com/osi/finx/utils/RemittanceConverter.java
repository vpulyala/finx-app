package com.osi.finx.utils;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.osi.finx.dto.QxIHubTransaction;
import com.osi.finx.model.QxmaFtRemittance;

public class RemittanceConverter {
	
	public RemittanceConverter() {
		
	}
	
	public static String jaxbObjectToXML(QxIHubTransaction iHubTransaction) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(QxIHubTransaction.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(iHubTransaction, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
	public static QxmaFtRemittance convertCSVItemToRemittance(String line) {
		QxmaFtRemittance qft = new QxmaFtRemittance();
		convertCsvItemCharges(qft, line);
		return qft;
	}
	
	private static void convertCsvItemCharges(QxmaFtRemittance qfr, String line) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		
		String[] values = line.split(",");
		try {
			qfr.setReferenceId(values[0]);
			qfr.setRemittedAt(sdf.parse(values[4]));
			qfr.setBankName(values[5]);
			qfr.setBankRef(values[6]);
			qfr.setAmountDeposited(new BigDecimal(values[7]));
			qfr.setRemittedBy(values[8]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		String line = "1,DELIVERED, POSTED STATUS : DELIVERED JOY TUGOT ,28-Feb-18,26-Mar-18,METROBANK,225 152 180326,538,LBC EXPRESS";
//		//RemittanceConverter.convertCSVItemToRemittance(line);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
//		try {
//			sdf.parse("20-AUG-18");
//			System.out.println("Date : " + sdf.parse("20-AUG-18"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		String[] splitter = line.split(",");
////		for(int i = 0; i < splitter.length; i++) {
////			System.out.println("[" +i+ "] = " + splitter[i]);
////		}
//	}
}
