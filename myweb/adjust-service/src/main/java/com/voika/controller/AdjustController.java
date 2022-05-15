package com.voika.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.voika.controller.dto.AdjustInfoCondition;
import com.voika.controller.vo.AdjustInfoVO;
import com.voika.entity.JsonData;
import com.voika.enums.AdjustInfoEnum;
import com.voika.service.AdjustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/adjust")
@Slf4j
public class AdjustController {

    @Resource
    private AdjustService adjustService;

    @PostMapping
    public JsonData search(@RequestBody AdjustInfoCondition condition) {
        List<AdjustInfoVO> data = null;
        try {
            data = adjustService.searchAdjustInfo(condition);
        } catch (Exception e) {
            log.error("查询调教记录出现异常，异常原因 ====>{}",e);
            return JsonData.error("查询调教记录时出现异常");
        }
        if (CollectionUtil.isEmpty(data)) {
            return JsonData.success("查询成功，但没有查询记录");
        }

        for (AdjustInfoVO x : data) {
            if (x.getDeleted().equals(AdjustInfoEnum.DELETED.getCode())) {
                x.setDeletedValue(AdjustInfoEnum.DELETED.getValue());
            }else {
                x.setDeletedValue(AdjustInfoEnum.UNDELETED.getValue());
            }

            if (x.getEffectiveness().equals(AdjustInfoEnum.EFFECTIVENESS.getCode())) {
                x.setEffectivenessValue(AdjustInfoEnum.EFFECTIVENESS.getValue());
            }else {
                x.setEffectivenessValue(AdjustInfoEnum.UNEFFECTIVENESS.getValue());
            }
        }
        return JsonData.success("查询成功",data);
    }


}
