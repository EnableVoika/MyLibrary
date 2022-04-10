package com.etoak;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.etoak.mapper")
public class KSApp {
    public static void main(String[] args) {
        SpringApplication.run(KSApp.class,args);
    }

}
