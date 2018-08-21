package com.osi.finx.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.osi.finx.dao.FxDisallowedRevenueDAO;
import com.osi.finx.service.FxDisallowedRevenueService;
import com.osi.finx.service.dto.FxDisallowedRevenueDTO;


public class FxDisallowedRevenueServiceImpl implements FxDisallowedRevenueService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FxDisallowedRevenueServiceImpl.class);  
    
	@Autowired  
    private FxDisallowedRevenueDAO disallowedRevenueDAO;
	
    /**
     * 
     */
    public FxDisallowedRevenueServiceImpl() {
        super();    
    }


    @SuppressWarnings("unchecked")
	@Override
	public List<FxDisallowedRevenueDTO> viewDisallowedRevenueDetails(String allowed,String endDate) {
		
		LOGGER.debug("FxDisallowedRevenueServiceImpl :: viewDisallowedRevenueDetails :: START");
		List<FxDisallowedRevenueDTO> disallowedRevenueDTOList = null;
		String startDate = null;
		try {
			if(endDate != null && !"".equals(endDate))
			{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			startDate = localDate.withDayOfMonth(1).toString();
			}
			List<Object[]> disallowedRevenueList = disallowedRevenueDAO.viewDisallowedRevenueDetails(allowed,startDate,endDate);
			if (disallowedRevenueList == null || (disallowedRevenueList != null && disallowedRevenueList.size() == 0)) {
			}
			disallowedRevenueDTOList = new ArrayList<FxDisallowedRevenueDTO>();
			for (Object[] obj : disallowedRevenueList) {
				double total = 0.0; 
				FxDisallowedRevenueDTO osiRmReportsDTO = new FxDisallowedRevenueDTO();
				osiRmReportsDTO.setPayloadId((String.valueOf(obj[0])));
				osiRmReportsDTO.setTrackingNo((String.valueOf(obj[1])));
				osiRmReportsDTO.setItem(String.valueOf(obj[2]));
				osiRmReportsDTO.setPaymentMethod(String.valueOf(obj[3]));
				osiRmReportsDTO.setDate((Date)obj[4]);
				osiRmReportsDTO.setShippingFee(Double.valueOf((obj[5].toString())));
				osiRmReportsDTO.setInsurance(Double.valueOf((obj[6].toString())));
				osiRmReportsDTO.setTrxFee(Double.valueOf((obj[7].toString())));
				osiRmReportsDTO.setReturnFee(Double.valueOf((obj[5].toString())));
				total = osiRmReportsDTO.getShippingFee()+osiRmReportsDTO.getInsurance()+osiRmReportsDTO.getTrxFee()+osiRmReportsDTO.getReturnFee();
				osiRmReportsDTO.setTotal(total);
				disallowedRevenueDTOList.add(osiRmReportsDTO);
			}
		} catch (DataAccessException e) {
			LOGGER.error("FxRgsReportServiceImpl :: viewDisallowedRevenueDetails :: ERROR ", e);

		}
		LOGGER.debug("FxRgsReportServiceImpl :: viewDisallowedRevenueDetails :: END");
		return disallowedRevenueDTOList;
	}
    
}