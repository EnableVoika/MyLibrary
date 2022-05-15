package com.voika;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = "com.voika.dao.**.mapper")
@SpringBootConfiguration
public class AdjustApp {

    public static void main(String[] args) {
        SpringApplication.run(AdjustApp.class,args);
    }

}
