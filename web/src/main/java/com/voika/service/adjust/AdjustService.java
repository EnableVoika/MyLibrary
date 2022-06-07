package com.voika.service.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.dao.adjust.MAdjustDao;
import com.voika.dao.adjust.repository.AdjustRepository;
import com.voika.infrastructure.config.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
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
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        for (Iterator<AdjustInfoVO> car = pojo.iterator();car.hasNext();) {
            AdjustInfoVO vo = car.next();
            //vo.setAdjustedDog("翊");
            if ("sin".equals(username)) {
                if (StringUtil.isNotEmpty(vo.getAdjustedDog()) && !vo.getAdjustedDog().contains("魔王龙")) {
                    car.remove();
                    continue;
                }
                vo.setAdjustedDog("翊");
                String adjustInfo = vo.getAdjustInfo();
                adjustInfo = adjustInfo.replaceAll("陛下","sin主人");
                adjustInfo = adjustInfo.replaceAll("魔王龙","龙奴");
                vo.setAdjustInfo(adjustInfo);
            }else if ("luni".equals(username)) {
                vo.setAdjustedDog("魔王龙");
            }else if ("jiedi".equals(username)) {
                if (StringUtil.isNotEmpty(vo.getAdjustedDog()) && !vo.getAdjustedDog().contains("魔王龙")) {
                    car.remove();
                    continue;
                }
                vo.setAdjustedDog("翊龙");
                String adjustInfo = vo.getAdjustInfo();
                adjustInfo = adjustInfo.replaceAll("陛下","杰迪主子");
                adjustInfo = adjustInfo.replaceAll("魔王龙","龙奴");
                vo.setAdjustInfo(adjustInfo);
            }else {
                vo.setAdjustedDog("翊");
            }
        }
        return pojo;
    }

    /**
     * 删除 TJ 记录
     */
    public int deletedAdjustInfo(Integer id) {
        return adjustRepository.deletedAdjustInfo(id);
    }

}
