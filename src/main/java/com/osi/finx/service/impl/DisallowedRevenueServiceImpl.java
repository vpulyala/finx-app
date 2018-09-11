package com.osi.finx.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.dao.DisallowedRevenueDAO;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.dto.DisallowedRevenueDTO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaPayload;
import com.osi.finx.service.DisallowedRevenueService;
import com.osi.finx.utils.DateUtil;


public class DisallowedRevenueServiceImpl implements DisallowedRevenueService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DisallowedRevenueServiceImpl.class);  
    
	@Autowired  
    private DisallowedRevenueDAO disallowedRevenueDAO;
	
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
	
    /**
     * 
     */
    public DisallowedRevenueServiceImpl() {
        super();    
    }


    @Override
	public List<DisallowedRevenueDTO> viewDisallowedRevenueDetails(String allowed,String endDate) throws OsiFinderException{
		
		LOGGER.debug("DisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: START");
		List<DisallowedRevenueDTO> disallowedRevenueDTOList = null;
		String startDate = null;
		try {
			if(endDate != null && !"".equals(endDate))
			{
			/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			startDate = localDate.withDayOfMonth(1).toString();*/
				startDate = DateUtil.getWeekStartDate(endDate);	
			}
			List<Object[]> disallowedRevenueList = disallowedRevenueDAO.viewDisallowedRevenueDetails(allowed,startDate,endDate);
			if (disallowedRevenueList == null || (disallowedRevenueList != null && disallowedRevenueList.size() == 0)) {
			}
			disallowedRevenueDTOList = new ArrayList<DisallowedRevenueDTO>();
			for (Object[] obj : disallowedRevenueList) {
				double total = 0.0; 
				DisallowedRevenueDTO osiRmReportsDTO = new DisallowedRevenueDTO();
				osiRmReportsDTO.setPayloadId((String.valueOf(obj[0])));
				osiRmReportsDTO.setTrackingNo((String.valueOf(obj[1])));
				osiRmReportsDTO.setItem(String.valueOf(obj[2]));
				osiRmReportsDTO.setPaymentMethod(String.valueOf(obj[3]));
				osiRmReportsDTO.setDate((Date)obj[4]);
				osiRmReportsDTO.setShippingFee(Double.valueOf((obj[5].toString())));
				osiRmReportsDTO.setInsurance(Double.valueOf((obj[6].toString())));
				osiRmReportsDTO.setTrxFee(Double.valueOf((obj[7].toString())));
				osiRmReportsDTO.setReturnFee(Double.valueOf((obj[5].toString())));
				osiRmReportsDTO.setIsDisallowed(Integer.valueOf(obj[8].toString()));
				total = osiRmReportsDTO.getShippingFee()+osiRmReportsDTO.getInsurance()+osiRmReportsDTO.getTrxFee()+osiRmReportsDTO.getReturnFee();
				osiRmReportsDTO.setTotal(total);
				disallowedRevenueDTOList.add(osiRmReportsDTO);
			}
		} catch (OsiFinderException e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: ERROR ", e);
			throw new OsiFinderException(e.getErrorCode(), e.getSystemMessage());
		}
		catch (Exception e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: ERROR ", e);
			throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("DisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: END");
		return disallowedRevenueDTOList;
	}
    
    
	@Override
	@Transactional
	public void saveAllowedRevenue(List<DisallowedRevenueDTO> disallowedRevDTOList) throws OsiTransactionException{
		
		LOGGER.debug("DisallowedRevenueServiceImpl :: saveAllowedRevenue :: START");
		byte allowed = 0;
		List<QxmaPayload> payloadList = null;
		try {
			payloadList = new ArrayList<QxmaPayload>();
			
			//disallowedRevenueDAO.saveAllowedOrDisallowedRevenue(disallowedRevDTOList);
			
			for (DisallowedRevenueDTO disallowedRevDTO : disallowedRevDTOList) {
				QxmaPayload payload = osiGenericDAO.findOne(disallowedRevDTO.getPayloadId(), QxmaPayload.class);
				payload.setIsDisallowed(allowed);
				payloadList.add(payload);
			}
			if(payloadList != null && payloadList.size()>0)
			{
				osiGenericDAO.saveOrUpdate(payloadList);
			}
			
		} 
		/*catch (OsiFinderException e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: ERROR ", e);
			throw new OsiFinderException(e.getErrorCode(), e.getSystemMessage());
		}
		catch (OsiTransactionException e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: saveAllowedRevenue :: ERROR ", e);
			throw new OsiTransactionException(e.getErrorCode(), e.getSystemMessage());
		}*/
		catch (Exception e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: saveAllowedRevenue :: ERROR ", e);
			throw new OsiTransactionException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("DisallowedRevenueServiceImpl :: saveAllowedRevenue :: END");
	}
    
    @Override
	public void processDisallowedRevenue(MultipartFile file) throws OsiTransactionException{
    	LOGGER.debug("DisallowedRevenueServiceImpl :: processDisallowedRevenue :: START");
    	Resource resource = new ClassPathResource("disallowedTrxnMapping.xml");
		XLSReader xlsReader;
		List<DisallowedRevenueDTO> disallowedList = null;
		try {
			  InputStream inputXML = new BufferedInputStream(new FileInputStream(resource.getFile()));   
			  xlsReader = ReaderBuilder.buildFromXML(inputXML);
			  disallowedList = new ArrayList<DisallowedRevenueDTO>();
		      final Map<String, Object> beans = new HashMap<String, Object>();
		      beans.put("disallowedTransList", disallowedList);          
		      xlsReader.read(file.getInputStream(), beans);
		      disallowedRevenueDAO.saveAllowedOrDisallowedRevenue(disallowedList);
		       
		} catch (Exception e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: processDisallowedRevenue :: ERROR ", e);
			throw new OsiTransactionException("ERR_0010", GENERIC_ERROR_CODES.ERR_0010);
		}
		LOGGER.debug("DisallowedRevenueServiceImpl :: processDisallowedRevenue :: END"); 
	}
    
    @Override
	public void generateAllowedRevGroup(List<DisallowedRevenueDTO> allowedRevDTOList) throws OsiTransactionException{
		
		LOGGER.debug("DisallowedRevenueServiceImpl :: generateAllowedRevGroup :: START");
		try {
			
			disallowedRevenueDAO.generateAllowedRevGroup(allowedRevDTOList);
			
		} 
		catch (OsiTransactionException e) {
			LOGGER.error("DisallowedRevenueServiceImpl :: generateAllowedRevGroup :: ERROR ", e);
			throw new OsiTransactionException(e.getErrorCode(), e.getSystemMessage());
		}
		LOGGER.debug("DisallowedRevenueServiceImpl :: generateAllowedRevGroup :: END");
	}
}