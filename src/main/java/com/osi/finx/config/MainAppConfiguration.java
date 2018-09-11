package com.osi.finx.config;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.osi.finx.dao.DisallowedRevenueDAO;
import com.osi.finx.dao.impl.DisallowedRevenueDAOImpl;
import com.osi.finx.service.DisallowedRevenueService;
import com.osi.finx.service.FeesService;
import com.osi.finx.service.impl.DisallowedRevenueServiceImpl;
import com.osi.finx.service.impl.FeesServiceImpl;


@Configuration
public class MainAppConfiguration {
    
	@Resource
	ConfigurableApplicationContext appContext;
	
    /**
     * Creating the DisallowedRevenueService bean.
     * @return {@link DisallowedRevenueService}
     */
    @Bean
    public DisallowedRevenueService getDisallowedRevenueService() {
        return new DisallowedRevenueServiceImpl();
    }

    /**
     * Creating the DisallowedRevenueDAO bean.
     * @return {@link DisallowedRevenueDAO}
     */
    @Bean
    public DisallowedRevenueDAO getDisallowedRevenueDAO() {
        return new DisallowedRevenueDAOImpl();
    }
    

    /**
     * Creating the FeesService bean.
     * @return {@link FeesService}
     */
    @Bean
    public FeesService getFeesService() {
        return new FeesServiceImpl();
    }

    
}