package com.voika.service.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.dao.adjust.MAdjustDao;
import com.voika.dao.adjust.repository.AdjustRepository;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdjustService {

    @Resource
    private MAdjustDao mAdjustDao;

    @Resource(name = "adjustRepositoryImpl")
    private AdjustRepository adjustRepository;

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */
    public List<AdjustInfoVO> searchAdjustInfo(AdjustCondition condition) {
        List<AdjustInfoVO> pojo = adjustRepository.searchAdjustInfo(condition);
        pojo.forEach(x -> x.parse());
        return pojo;
    }

    /**
     * 删除 TJ 记录
     */
    public int deletedAdjustInfo(Integer id) {
        return adjustRepository.deletedAdjustInfo(id);
    }

}
