package com.osi.finx.dao.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.osi.finx.dao.FinXLoginDAO;
import com.osi.finx.model.QxmaUser;

@Repository
public class FinXLoginDAOImpl implements FinXLoginDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinXLoginDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public QxmaUser login(String username, String password) {
		LOGGER.debug("FinXLoginDAOImpl :: login :: START");
		QxmaUser user = null;
		
		try{
			
			Query q = entityManager.createQuery("FROM QxmaUser WHERE username= :username AND password= :password");
			q.setParameter("username", username);
			q.setParameter("password", password);
			
			user = (QxmaUser) q.getSingleResult();
			
		}catch(Exception e){
			LOGGER.error("FinXLoginDAOImpl :: login :: ERROR ", e);
			return null;
		}

		LOGGER.debug("FinXLoginDAOImpl :: login :: END");
		return user;
	}

	@Transactional
	@Override
	public int changePassword(String userId, String newPassword) {
		LOGGER.debug("FinXLoginDAOImpl :: changePassword :: START");
		int result = 0;
		try{
			Query q = entityManager.createQuery("update QxmaUser set password = :newPassword, isFirstLogin = 0 where userId = :userId");
			q.setParameter("newPassword", newPassword);
			q.setParameter("userId", new BigInteger(userId));
			
			result = q.executeUpdate();
		}catch(Exception e){
			LOGGER.error("FinXLoginDAOImpl :: changePassword :: ERROR ", e);
		}

		LOGGER.debug("FinXLoginDAOImpl :: changePassword :: END");
		return result;
	}

}
