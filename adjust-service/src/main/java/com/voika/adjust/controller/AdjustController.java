package com.voika.adjust.controller;

import com.voika.adjust.dao.po.AdjustCodeAndValue;
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
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping
public class AdjustController {

    @Resource
    private AdjustService adjustService;

    @Resource
    private StringRedisTemplate redis;

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

    /**
     * 更新狗子调教记录
     */
    @PostMapping("update/adjust/info")
    public JsonResponse updateAdjustInfo(@RequestBody AdjustDTO dto) {
        String dogName = dto.getAdjustedDog();
        Integer count = dto.getAdjustCount();
        Integer code = dto.getAdjustContentCode();
        Integer id = dto.getId();

        if (null == id) {
            return Response.error("id不能为空哦～");
        }

        if (StringUtils.isEmpty(dogName)) {
            return Response.error("狗子名字不能为空哦～～主子～～～倒是调教次数可以为空或者非负数～～～");
        }
        if (null == code) {
            return Response.error("调教内容不能为空哦主子～～～mua");
        }
        if (null == count) {
            dto.setAdjustCount(0);
        }
        AdjustPO po = new AdjustPO();
        BeanUtils.copyProperties(dto,po);
        String value = redis.opsForValue().get("updateAdjustInfo_" + id);
        if (StringUtils.isEmpty(value)) {
            redis.opsForValue().set("updateAdjustInfo_"+id,String.valueOf(po.hashCode()),2400, TimeUnit.SECONDS);
        }else {
            int hashCode = po.hashCode();
            if (String.valueOf(hashCode).equals(value)) {
                return Response.error("未做任何修改");
            }
            redis.delete("updateAdjustInfo_"+id);
        }
        int i = adjustService.updateAdjustInfoById(po);
        if (i <= 0) return Response.error("未做任何修改");
        return Response.success("接口测试成功");
    }

    /**
     * 获得调教code和value
     * @return
     */
    @GetMapping("codeAndValue")
    public JsonResponse getCodeList() {
        List<AdjustCodeAndValue> data = adjustService.getCodeList();
        return Response.success("获取成功",data);
    }


}
