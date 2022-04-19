package com.voika.adjust.controller;

import com.voika.adjust.dao.edgeadjust.po.EdgeAdjustPO;
import com.voika.adjust.service.EdgeAdjustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/edge")
public class EdgeAdjustController {

    @Resource
    private EdgeAdjustService edgeAdjustService;

    @RequestMapping("/query/condition")
    public List<EdgeAdjustPO> queryCondition() {

        return edgeAdjustService.queryCondition();
    }

}
