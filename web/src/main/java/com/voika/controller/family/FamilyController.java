package com.voika.controller.family;

import com.voika.controller.family.dto.InsertFamilyMoneyDTO;
import com.voika.controller.family.dto.SearchFamilyMoneyDTO;
import com.voika.controller.family.vo.FamilyMoneyVO;
import com.voika.infrastructure.JsonData;
import com.voika.service.family.FamilyMoneyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
//@RequiresAuthentication
//@RequiresRoles("family")
@RequestMapping("/family")
@Slf4j
public class FamilyController {

    @Resource
    private FamilyMoneyService familyMoneyService;

    /**
     * 分页查询
     */
    @PostMapping("/search/condition")
//    @RequiresPermissions("view")
    public JsonData searchCondition(@RequestBody SearchFamilyMoneyDTO dto) {
        List<FamilyMoneyVO> pojo = null;
        try {
            pojo = familyMoneyService.searchCondition(dto);
        } catch (Exception e) {
            JsonData.error("查询资金记录时出现异常");
        }
        return JsonData.success(pojo);
    }

    /**
     * 创建资金记录
     */
    @PostMapping("/create/moneyinfo")
    //@RequiresPermissions("create")
    public JsonData createMoneyInfo(@RequestBody(required = false) InsertFamilyMoneyDTO dto) {
        if (null == dto.getMoney()) {
            return JsonData.error("资金不能为空");
        }
        if (null == dto.getMoneyStatus()) {
            return JsonData.error("资金状态不能是空");
        }
        int count = 0;
        try {
            count = familyMoneyService.insertFamilyMoney(dto);
        } catch (Exception e) {
            log.error("插入资金记录时出现异常,", e);
            return JsonData.error("插入资金记录时出现异常");
        }
        return JsonData.success("插入了" + count + "条记录");
    }

}
