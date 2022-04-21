package com.voika.adjust.infrastructure.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfiguration {

    /**
     * 过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean<CrossFilter> fiter() {
        FilterRegistrationBean<CrossFilter> registrationBean
                = new FilterRegistrationBean();
        registrationBean.setFilter(new CrossFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
