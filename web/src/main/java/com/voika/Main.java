package com.voika;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.voika.dao")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

}
