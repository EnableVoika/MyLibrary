package com.etoak.utils;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

@Configuration
public class CostomerFilter {

    @Bean
    public Filter myFilter() {
        return new CrossFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.addUrlPatterns("/*");
        filter.setFilter(myFilter());
        filter.setOrder(1);
        return filter;
    }


}
