package com.etoak.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("test")
public class TestController {

    @Value("${image.dir}")
    private String dir;

    @RequestMapping
    public String test() throws IOException {
//        dir += "/houduantest";
//        File file = new File(dir);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//        System.out.println();
        return "测试接口调用成功！";
    }

}
