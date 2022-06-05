package com.voika.controller.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.infrastructure.JsonData;
import com.voika.service.adjust.AdjustService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/furry")
public class AdjustController {

    @Resource
    private AdjustService adjustService;

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */
    @PostMapping("/adjust/search/condition")
    public JsonData searchAdjustInfo(@RequestBody AdjustCondition condition) {
        List<AdjustInfoVO> data = adjustService.searchAdjustInfo(condition);
        return JsonData.success(data);
    }

}
