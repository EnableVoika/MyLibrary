package com.etoak;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.etoak.mapper")
@Slf4j
public class KSApp {
    public static void main(String[] args) {
        log.info("项目正在启动...");
        SpringApplication.run(KSApp.class,args);
        log.info("项目启动成功");
    }

}
