package com.voika.adjust.controller;

import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.dto.adjust.AdjustDTO;
import com.voika.adjust.infrastructure.response.JsonResponse;
import com.voika.adjust.infrastructure.response.Response;
import com.voika.adjust.infrastructure.util.AdjustUtil;
import com.voika.adjust.infrastructure.vo.adjust.AdjustVO;
import com.voika.adjust.service.AdjustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping
public class AdjustController {

    @Resource
    private AdjustService adjustService;

    /**
     * 分页查询调教的狗的信息
     * @param condition
     * @return
     */
    @RequestMapping("/query/condition")
    public JsonResponse queryCondition(@RequestBody(required = false) AdjustCondition condition) {
        List<AdjustVO> data = adjustService.queryCondition(condition);
        for (AdjustVO vo : data) {
            AdjustUtil.parseAdjustCode(vo);
        }
        return Response.success("请求成功",data);
    }

    /**
     * 插入调教记录
     * @return
     */
    @PostMapping("/insert/adjustInfo")
    public JsonResponse insertAdjustInfo(@RequestBody AdjustDTO dto) {

        String adjustedDog = dto.getAdjustedDog();
        Integer adjustContentCode = dto.getAdjustContentCode();
        String adjustInfo = dto.getAdjustInfo();
        Integer adjustCount = dto.getAdjustCount();
        String adjustDatetime = dto.getAdjustDatetime();


        AdjustPO po = new AdjustPO();
        BeanUtils.copyProperties(dto,po);
        int result = -1;
        try {
            result  = adjustService.insertAdjustInfo(po);
        }catch (Exception e) {
            log.error("插入狗子调教记录失败,失败原因====>{}",e);
            return Response.error("插入狗子调教记录出现异常");
        }

        if (result == 0) {
            return Response.error("未插入任何数据");
        }
        return Response.success("狗子调教记录插入成功！");
    }

    /**
     * 逻辑删除调教记录
     * @param id
     * @return
     */
    @DeleteMapping("/del/{id}")
    public JsonResponse delAdjustInfo(@PathVariable int id) {
        int res = -1;
        try {
            res = adjustService.delAdjustInfo(id);
        }catch (Exception e) {
            log.error("删除调教记录出现异常，异常原因====>{}",e);
            return Response.error("删除调教记录出现异常，请联系狗子");
        }
        if (res <= 0) {
            Response.error("未删除任何信息");
        }
        return Response.success("恭喜主子删除成功！");
    }

}
