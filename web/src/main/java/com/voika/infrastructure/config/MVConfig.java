package com.voika.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MVConfig implements WebMvcConfigurer {

    @Resource
    private Interceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

}

