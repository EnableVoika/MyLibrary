package com.edge.adjust.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("edge")
public class EdgeAdjustController {

    @RequestMapping
    public String test() {
        return "测试接口调用成功";
    }

}
