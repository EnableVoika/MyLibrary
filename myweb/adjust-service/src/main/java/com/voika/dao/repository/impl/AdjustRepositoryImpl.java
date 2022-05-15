package com.voika.dao.repository.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.voika.controller.dto.AdjustInfoCondition;
import com.voika.controller.vo.AdjustInfoVO;
import com.voika.dao.mapper.AdjustInfoMapper;
import com.voika.dao.po.AdjustInfoPO;
import com.voika.dao.repository.AdjustRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdjustRepositoryImpl implements AdjustRepository {

    @Resource
    private AdjustInfoMapper adjustInfoMapper;

    /**
     * 分页查询调教记录
     * @param condition
     * @return
     */
    @Override
    public List<AdjustInfoVO> searchAdjustInfo(AdjustInfoCondition condition) {
        List<AdjustInfoVO> data =
                adjustInfoMapper.searchAdjustInfo(condition);
        return CollectionUtil.isEmpty(data) ? new ArrayList<>() : data;
    }
}
