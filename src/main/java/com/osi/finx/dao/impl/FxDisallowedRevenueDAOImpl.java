package com.osi.finx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.osi.finx.dao.FxDisallowedRevenueDAO;

public class FxDisallowedRevenueDAOImpl implements FxDisallowedRevenueDAO {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(FxDisallowedRevenueDAOImpl.class);		
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> viewDisallowedRevenueDetails(String allowed,String startDate,String endDate) {
		
		LOGGER.debug("FxDisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: START");
		StringBuffer query = new StringBuffer();
		List<Object[]> disallowedRevenueList = new ArrayList<>();
		boolean isAllowed = false;
		try
		{
		query.append(" SELECT qp.payload_id,qp.tracking_number,qpi.description,CAST(qp.payment->>'$.method' AS CHAR),qp.status_updated_at,IFNULL(qpb.shipping,0.0),IFNULL(qpb.insurance,0.0),IFNULL(CAST(qp.fees->> '$.transaction_fee' AS DECIMAL(19,2)),0.0) FROM qxma_payload qp LEFT JOIN qxma_pl_item qpi ON qp.payload_id=qpi.payload_id LEFT JOIN qxma_pl_breakdown qpb ON qp.payload_id=qpb.payload_id ");
		
		if( (allowed == null || "".equals(allowed)) && (startDate == null || "".equals(startDate)) && (endDate == null || "".equals(endDate)) )
		{}
		else
		{
		if(allowed.equalsIgnoreCase("Allowed"))
				isAllowed = true;
		if(allowed != null  && !"".equals(allowed))
    	    query.append(" WHERE qp.is_disallowed="+isAllowed);
		
	    if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate))
			query.append(" AND qp.status_updated_at BETWEEN date_format('"+startDate+"','%y-%m-%d') AND date_format('"+endDate+"','%y-%m-%d') ");
		}
		disallowedRevenueList = entityManager.createNativeQuery(query.toString()).setMaxResults(10).getResultList(); 
		}
		catch (Exception e) {
			LOGGER.error("FxDisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: ERROR ", e);
		}
		LOGGER.debug("FxDisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: END");
		return disallowedRevenueList;
	}
    	
}