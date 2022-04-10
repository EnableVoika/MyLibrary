package com.etoak.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Value("${image.dir}")
    private String dir;

    @RequestMapping
    public String test() throws IOException {
        log.info("测试日志");
        System.out.println("打印语句测试git变颜色");
        return "测试接口调用成功！";
    }

}
