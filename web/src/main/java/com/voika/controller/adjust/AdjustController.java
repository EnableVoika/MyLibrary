package com.voika.controller.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.infrastructure.JsonData;
import com.voika.service.adjust.AdjustService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequiresAuthentication
@RequiresRoles("furry")
@RequestMapping("/furry")
public class AdjustController {

    @Resource
    private AdjustService adjustService;

    /**
     * 查询 furry_slave 的 TJ 信息
     *
     * @return
     */
    @RequiresPermissions("view")
    @PostMapping("/adjust/search/condition")
    public JsonData searchAdjustInfo(@RequestBody AdjustCondition condition) {
        List<AdjustInfoVO> data = adjustService.searchAdjustInfo(condition);
        return JsonData.success(data);
    }

    /**
     * 删除 TJ 记录
     */
    @RequiresPermissions({"delete","update"})
    @RequiresRoles("furry:master")
    @DeleteMapping("/delete/{id}")
    public JsonData deletedAdjustInfo(@PathVariable("id") Integer id) {
        if (null == id) {
            JsonData.error("id不能为空");
        }
        int i = adjustService.deletedAdjustInfo(id);
        return i >0?JsonData.success("删除成功，给龙奴一个惊喜吧～！"):JsonData.error("龙奴感谢陛下的仁慈");
    }

}
