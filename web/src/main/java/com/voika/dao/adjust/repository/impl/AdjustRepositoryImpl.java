package com.voika.dao.adjust.repository.impl;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import com.voika.dao.adjust.MAdjustDao;
import com.voika.dao.adjust.repository.AdjustRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AdjustRepositoryImpl implements AdjustRepository {

    @Resource
    private MAdjustDao mAdjustDao;

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */
    @Override
    public List<AdjustInfoVO> searchAdjustInfo(AdjustCondition condition) {
        return mAdjustDao.searchAdjustInfo(condition);
    }

    /**
     * 逻辑删除 TJ 记录
     */
    @Override
    public int deletedAdjustInfo(Integer id) {
        return mAdjustDao.deletedAdjustInfo(id);
    }
}
