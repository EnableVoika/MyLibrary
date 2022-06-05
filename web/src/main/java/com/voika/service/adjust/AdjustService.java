package com.voika.service.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.dao.adjust.MAdjustDao;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@RequiresAuthentication
@RequiresRoles("furry")
public class AdjustService {

    @Resource
    private MAdjustDao mAdjustDao;

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */

    @RequiresPermissions("view")
    public List<AdjustInfoVO> searchAdjustInfo(AdjustCondition condition) {
        List<AdjustInfoVO> pojo = mAdjustDao.searchAdjustInfo(condition);
        pojo.forEach(x -> x.parse());
        return pojo;
    }

}
