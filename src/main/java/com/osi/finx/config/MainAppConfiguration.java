package com.osi.finx.config;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.osi.finx.service.FxDisallowedRevenueService;
import com.osi.finx.service.impl.FxDisallowedRevenueServiceImpl;
import com.osi.finx.dao.FxDisallowedRevenueDAO;
import com.osi.finx.dao.impl.FxDisallowedRevenueDAOImpl;


@Configuration
public class MainAppConfiguration {
    
	@Resource
	ConfigurableApplicationContext appContext;
	
    /**
     * Creating the FxDisallowedRevenueService bean.
     * @return {@link FxDisallowedRevenueService}
     */
    @Bean
    public FxDisallowedRevenueService getFxDisallowedRevenueService() {
        return new FxDisallowedRevenueServiceImpl();
    }

    /**
     * Creating the FxDisallowedRevenueDAO bean.
     * @return {@link FxDisallowedRevenueDAO}
     */
    @Bean
    public FxDisallowedRevenueDAO getFxDisallowedRevenueDAO() {
        return new FxDisallowedRevenueDAOImpl();
    }
    
}