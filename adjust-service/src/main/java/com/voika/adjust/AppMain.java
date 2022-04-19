package com.voika.adjust;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.voika.dao")
public class AppMain {

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class,args);
    }

}
