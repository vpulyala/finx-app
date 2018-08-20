package com.osi.finx.config;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.osi.finx.service.QxDisallowedRevenueService;
import com.osi.finx.service.impl.QxDisallowedRevenueServiceImpl;
import com.osi.finx.dao.QxDisallowedRevenueDAO;
import com.osi.finx.dao.impl.QxDisallowedRevenueDAOImpl;


@Configuration
public class MainAppConfiguration {
    
	@Resource
	ConfigurableApplicationContext appContext;
	
    /**
     * Creating the QxDisallowedRevenueService bean.
     * @return {@link QxDisallowedRevenueService}
     */
    @Bean
    public QxDisallowedRevenueService getQxDisallowedRevenueService() {
        return new QxDisallowedRevenueServiceImpl();
    }

    /**
     * Creating the QxDisallowedRevenueDAO bean.
     * @return {@link QxDisallowedRevenueDAO}
     */
    @Bean
    public QxDisallowedRevenueDAO getQxDisallowedRevenueDAO() {
        return new QxDisallowedRevenueDAOImpl();
    }
    
}