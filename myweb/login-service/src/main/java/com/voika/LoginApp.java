package com.voika;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.voika.dao.**.mapper")
@SpringBootApplication
@SpringBootConfiguration
public class LoginApp {

    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class,args);
    }

//    @Bean
//    public FilterRegistrationBean filter() {
//        FilterRegistrationBean<Filter> filter =
//                new FilterRegistrationBean<>();
//        filter.setFilter(new CrossFilter());
//        filter.setOrder(1);
//        filter.addUrlPatterns("/*");
//        return filter;
//    }

}
