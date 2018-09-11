package com.osi.finx.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import com.osi.finx.constants.OsiConstants;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.dao.OsiGenericDAO;

@Component
public class OsiGenericDAOImpl implements OsiGenericDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OsiGenericDAOImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Main Implementation of Find One to search for single entities.
	 * @throws OsiFinderException 
	 */
	public <T> T findOne(final Serializable id, Class<T> clazz) throws OsiFinderException{
		LOGGER.debug("OsiGenericDAOImpl :: findOne :: START");
		try {
			return entityManager.find(clazz, id);
		} catch (Exception e) {
			LOGGER.error("OsiGenericDAOImpl :: findOne :: ERROR :: ", e);
			LOGGER.debug("OsiGenericDAOImpl :: findOne :: END");
			throw new OsiFinderException("ERR_0003",OsiConstants.GENERIC_ERROR_CODES.ERR_0003,e);
		}	
	}
	
	/**
	 * Main Implementation of finaAll to search for Multiple entities of the same class.
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> clazz){
		try {
			return entityManager.createQuery("from " + clazz.getName()).getResultList();
		} catch (Exception ex) {
			LOGGER.error("Exception occured while find all entities", ex);

		}
		return null;		
	}
	
	/**
	 * Main Implementation of the save method to save a single entity.
	 */
	public <T> T save(T entity){
		try {
			entityManager.persist(entity);
			return entity;
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving an entity", e);
		}
		return null;		
	}
	
	/**
	 * Main Implementation of the merge method to update any single entity of any single class.
	 */
	public <T> T merge(T t){
		try {
			return entityManager.merge(t);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception occured while updating an entity", e);
		}
		return null;		
	}
	
	/**
	 * Main Implementation of the delete method to delete any single entity.
	 */
	public <T> void delete(final T entity){
		try {
			entityManager.remove(entity);
		} catch (Exception e) {
			LOGGER.error("Exception occured while deleting an entity", e);
		}		
	}
	
	/**
	 * Main Implementation of the deleteById method to delete an entity having only a reference to its ID.
	 * @throws OsiFinderException 
	 */
	public <T> void deleteById(final int entityId, Class<T> clazz) throws OsiFinderException{
		final T entity = findOne(entityId, clazz);
		delete(entity);		
	}
	
	/**
	 * Main Implementation of the copyEntity method to get detached copies of any single entity.
	 */
	public <T> T copyEntity(T entity){
		//entityManager.flush();
		try {
			//entityManager.flush();
			entityManager.detach(entity);
			return entity;
		} catch (Exception e) {
			LOGGER.error("Exception occured while cloning an entity", e);
		}	
		return null;		
	}
	
	/**
	 * Main Implementation of the copyEntities method to get detached copies of a list of any single entity type.
	 */
	public <T> List<T> copyEntities(List<T> entities){
		try {
			for(T entity : entities){
				//entityManager.flush();
				entityManager.detach(entity);
			}
			return entities;
		} catch (Exception e) {
			LOGGER.error("Exception occured while cloning an entity", e);
		}	
		return null;		
	}
	
	/**
	 * Main Implementation of the saveOrUpdate method to attempt to save a list of entities and merge them if teh saving fails.
	 * @throws OsiTransactionException 
	 */
	public <T> Boolean saveOrUpdate(List<T> entities) throws OsiTransactionException{
		LOGGER.debug("OsiGenericDAOImpl :: saveOrUpdate (List) :: START");
		
		Boolean saveUpdateSuccess = true;
		
		for(T entity : entities){
			boolean savingFailed = false;
			
			try{
				entityManager.merge(entity);
			}catch(DataIntegrityViolationException e){
				savingFailed = true;
				LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate (List) :: ERROR :: ", e);
				throw new OsiTransactionException("ERR_0004",OsiConstants.GENERIC_ERROR_CODES.ERR_0004,e);
			}catch(ConstraintViolationException e){
				savingFailed = true;
				LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate (List) :: ERROR :: ", e);
				LOGGER.debug("OsiGenericDAOImpl :: saveOrUpdate (List) :: END");
				throw new OsiTransactionException("ERR_0005",OsiConstants.GENERIC_ERROR_CODES.ERR_0005,e);
			}
			
			if(savingFailed){
				try{
					entityManager.persist(entity);
				}catch(Exception e){
					LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate (List) :: ERROR :: ", e);
					throw new OsiTransactionException("ERR_0003",OsiConstants.GENERIC_ERROR_CODES.ERR_0003,e);
				}
			}
		}
		
		LOGGER.debug("OsiGenericDAOImpl :: saveOrUpdate (List) :: END");
		return saveUpdateSuccess;		
	}
	
	/**
	 * Main Implementation of the saveOrUpdate method for single entities.
	 * @throws OsiTransactionException 
	 */
	public <T> Boolean saveOrUpdate(T entity) throws OsiTransactionException{
		LOGGER.debug("OsiGenericDAOImpl :: saveOrUpdate :: START");
		Boolean saveUpdateSuccess = true;
		boolean savingFailed = false;
		
		try{
			entityManager.merge(entity);
		}catch(DataIntegrityViolationException e){
			savingFailed = true;
			LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate :: ERROR :: ", e);
			throw new OsiTransactionException("ERR_0004",OsiConstants.GENERIC_ERROR_CODES.ERR_0004,e);
		}catch(ConstraintViolationException e){
			savingFailed = true;
			LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate :: ERROR :: ", e);
			throw new OsiTransactionException("ERR_0005",OsiConstants.GENERIC_ERROR_CODES.ERR_0005,e);
		}
		
		if(savingFailed){
			try{
				entityManager.persist(entity);
			}catch(Exception e){
				LOGGER.error("OsiGenericDAOImpl :: saveOrUpdate :: ERROR :: ", e);
				throw new OsiTransactionException("ERR_0003",OsiConstants.GENERIC_ERROR_CODES.ERR_0003,e);
			}
		}
		
		LOGGER.debug("OsiGenericDAOImpl :: saveOrUpdate :: END");
		return saveUpdateSuccess;		
	}
	
	/**
	 * Main Implementation of the save method to save a single entity.
	 */
	@Transactional
	public <T> T saveTransactional(T entity){
		try {
			entityManager.persist(entity);
			return entity;
		} catch (Exception e) {
			LOGGER.error("Exception occured while saving an entity", e);
		}
		return null;		
	}	
	
	/**
	 * Main Implementation of the merge method to update any single entity of any single class.
	 */
	@Transactional
	public <T> T mergeTransactional(T t){
		try {
			return entityManager.merge(t);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception occured while updating an entity", e);
		}
		return null;		
	}
	
	
	/**
	 * Get a reference to the persistent entity manager.
	 * @return
	 */
	public EntityManager getEntityManager(){
		return entityManager;
	}

}
