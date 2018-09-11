package com.osi.finx.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.osi.finx.dao.AccountDAO;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void deleteAccount (String code){
		LOGGER.info("AccountDAOImpl :: deleteAccount :: START");
		
		Query q = entityManager.createQuery("DELETE FROM QxmaAccount qxa WHERE qxa.code= :code");
		q.setParameter("code", code);
		
		q.executeUpdate();
		
		LOGGER.info("AccountDAOImpl :: deleteAccount :: END");
	}
	
}
