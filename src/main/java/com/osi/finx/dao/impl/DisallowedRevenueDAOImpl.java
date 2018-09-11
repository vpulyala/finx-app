package com.osi.finx.dao.impl;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.uuid.Generators;
import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.dao.DisallowedRevenueDAO;
import com.osi.finx.dto.DisallowedRevenueDTO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;

public class DisallowedRevenueDAOImpl implements DisallowedRevenueDAO {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(DisallowedRevenueDAOImpl.class);		
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> viewDisallowedRevenueDetails(String allowed,String startDate,String endDate) throws OsiFinderException{
		
		LOGGER.debug("DisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: START");
		StringBuffer query = new StringBuffer();
		List<Object[]> disallowedRevenueList = new ArrayList<>();
		boolean isAllowed = false;
		try
		{
		query.append(" SELECT qp.payload_id,qp.tracking_number,qpi.description,CAST(qp.payment->>'$.method' AS CHAR),qp.status_updated_at,IFNULL(qpb.shipping,0.0),IFNULL(qpb.insurance,0.0),IFNULL(CAST(qp.fees->> '$.transaction_fee' AS DECIMAL(19,2)),0.0),qp.is_disallowed FROM qxma_payload qp LEFT JOIN qxma_pl_item qpi ON qp.payload_id=qpi.payload_id LEFT JOIN qxma_pl_breakdown qpb ON qp.payload_id=qpb.payload_id WHERE (qp.group_id IS NULL OR qp.group_id='') ");
		
		if( (allowed == null || "".equals(allowed)) && (startDate == null || "".equals(startDate)) && (endDate == null || "".equals(endDate)) )
		{}
		else
		{
			if(startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate))
		    {
		    	query.append(" AND DATE_FORMAT(qp.status_updated_at,'%y-%m-%d') BETWEEN DATE_FORMAT('"+startDate+"','%y-%m-%d') AND DATE_FORMAT('"+endDate+"','%y-%m-%d')");
		    }
			if(allowed.equalsIgnoreCase("Disallowed"))
				isAllowed = true;
		    if(allowed != null  && !"".equals(allowed) && !allowed.equalsIgnoreCase("All"))
    	        query.append(" AND qp.is_disallowed="+isAllowed);
	    }
		disallowedRevenueList = entityManager.createNativeQuery(query.toString()).getResultList(); 
		}
		catch (Exception e) {
			LOGGER.error("DisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: ERROR ", e);
			throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("DisallowedRevenueDAOImpl :: viewDisallowedRevenueDetails :: END");
		return disallowedRevenueList;
	}
    
	@Override
	@Transactional
	public void saveAllowedOrDisallowedRevenue(List<DisallowedRevenueDTO> disallowedRevDTOList) throws OsiTransactionException
	{
		LOGGER.debug("DisallowedRevenueDAOImpl :: saveAllowedOrDisallowedRevenue :: START");		
		
          try
          {
			Session hibernateSession = entityManager.unwrap(Session.class);

			hibernateSession.doWork(new org.hibernate.jdbc.Work() {

				PreparedStatement ps = null;
				String updateSql = null;
				
				@Override
			    public void execute(Connection con) throws SQLException {
		
					updateSql = "UPDATE qxma_payload SET is_disallowed = ? WHERE payload_id = ?";		
		         try{
			
					
					ps = con.prepareStatement(updateSql);
				
					for (DisallowedRevenueDTO disallowedRevDTO : disallowedRevDTOList) {
						ps.setInt(1, disallowedRevDTO.getIsDisallowed());
						ps.setString(2, disallowedRevDTO.getPayloadId());
						ps.addBatch();
					}
					ps.executeBatch();	
				}catch (BatchUpdateException e) {
					LOGGER.error("DisallowedRevenueDAOImpl :: saveAllowedOrDisallowedRevenue :: ERROR ", e);
					throw e;
				}finally {
					try {
						if(ps != null) ps.close();
						if(con != null) 	con.close();
					} catch (SQLException e) {
						LOGGER.error("DisallowedRevenueDAOImpl :: saveAllowedOrDisallowedRevenue :: ERROR ", e);
						throw e;
					}	
				}
			
		    }
				  
			});
          }
          catch (Exception e) {
  			LOGGER.error("DisallowedRevenueDAOImpl :: saveAllowedOrDisallowedRevenue :: ERROR ", e);
  			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
  		}
			
		LOGGER.debug("DisallowedRevenueDAOImpl :: saveAllowedOrDisallowedRevenue :: END");
}	
	
	@Override
	@Transactional
	public void generateAllowedRevGroup(List<DisallowedRevenueDTO> allowedRevDTOList) throws OsiTransactionException
	{
		LOGGER.debug("DisallowedRevenueDAOImpl :: generateAllowedRevGroup :: START");		
		
          try
          {
        	      	
        	UUID uuid = Generators.timeBasedGenerator().generate();
        	 
			Session hibernateSession = entityManager.unwrap(Session.class);

			hibernateSession.doWork(new org.hibernate.jdbc.Work() {

				PreparedStatement ps = null;
				String updateSql = null;
				
				@Override
			    public void execute(Connection con) throws SQLException {
		
					updateSql = "UPDATE qxma_payload SET group_id = ? WHERE payload_id = ?";		
		         try{
			
					
					ps = con.prepareStatement(updateSql);
				
					for (DisallowedRevenueDTO allowedRevDTO : allowedRevDTOList) {
						ps.setString(1, uuid.toString());
						ps.setString(2, allowedRevDTO.getPayloadId());
						ps.addBatch();
					}
					ps.executeBatch();	
				}catch (BatchUpdateException e) {
					LOGGER.error("DisallowedRevenueDAOImpl :: generateAllowedRevGroup :: ERROR ", e);
					throw e;
				}finally {
					try {
						if(ps != null) ps.close();
						if(con != null) 	con.close();
					} catch (SQLException e) {
						LOGGER.error("DisallowedRevenueDAOImpl :: generateAllowedRevGroup :: ERROR ", e);
						throw e;
					}	
				}
			
		    }
				  
			});
          }
          catch (Exception e) {
  			LOGGER.error("DisallowedRevenueDAOImpl :: generateAllowedRevGroup :: ERROR ", e);
  			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
  		}
			
		LOGGER.debug("DisallowedRevenueDAOImpl :: generateAllowedRevGroup :: END");
}		
}