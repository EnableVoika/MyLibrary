package com.voika.adjust.controller;

import com.voika.adjust.service.EdgeAdjustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/edge")
public class EdgeAdjustController {

    @Resource
    private EdgeAdjustService edgeAdjustService;

    @RequestMapping("/query/condition")
    public String queryCondition() {
        return "接口测试成功";
    }

}
