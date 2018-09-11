package com.osi.finx.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;

@Component
public interface OsiGenericDAO {
	
	/**
	 * Find any single entity by providing their primary key and the class type for the entity.
	 * @param id
	 * @param clazz
	 * @return
	 * @throws OsiFinderException 
	 */
	public <T> T findOne(final Serializable id, Class<T> clazz) throws OsiFinderException;
	
	/**
	 * Find all entities of teh provided class type.
	 * @param clazz
	 * @return
	 */
	public <T> List<T> findAll(Class<T> clazz);
	
	/**
	 * Save any single entity.
	 * @param entity
	 * @return
	 */
	public <T> T save(T entity);
	
	/**
	 * Merge any single entity.
	 * @param t
	 * @return
	 */
	public <T> T merge(T t);
	
	/**
	 * Delete any single entity.
	 * @param entity
	 */
	public <T> void delete(final T entity);
	
	/**
	 * Delete an entity by id.
	 * @param entityId
	 * @param clazz
	 * @throws OsiFinderException 
	 */
	public <T> void deleteById(final int entityId, Class<T> clazz) throws OsiFinderException;
	
	/**
	 * Get a detached copy of the entity. An unpersisted version of it.
	 * @param entity
	 * @return
	 */
	public <T> T copyEntity(T entity);
	
	/**
	 * Get a detached copy of a list of entities.
	 * @param entities
	 * @return
	 */
	public <T> List<T> copyEntities(List<T> entities);
	
	/**
	 * Save a list of entities of any single class, if the saving fails, the method should try to merge them.
	 * @param entities
	 * @return
	 * @throws OsiTransactionException 
	 */
	public <T> Boolean saveOrUpdate(List<T> entities) throws OsiTransactionException;
	
	/**
	 * Save any single entity, if the saving fails, the method should try to merge it.
	 * @param entity
	 * @return
	 * @throws OsiTransactionException 
	 */
	public <T> Boolean saveOrUpdate(T entity) throws OsiTransactionException;
	
	/**
	 * Save any single entity immediately.
	 * @param entity
	 * @return
	 */
	public <T> T saveTransactional(T entity);
	
	public <T> T mergeTransactional(T t);

}
