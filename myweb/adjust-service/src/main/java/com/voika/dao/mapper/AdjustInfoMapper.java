package com.voika.dao.mapper;

import com.voika.controller.dto.AdjustInfoCondition;
import com.voika.controller.vo.AdjustInfoVO;
import com.voika.dao.po.AdjustInfoPO;

import java.util.List;

public interface AdjustInfoMapper {

    /**
     * 分页查询调教记录
     * @param condition
     * @return
     */
    List<AdjustInfoVO> searchAdjustInfo(AdjustInfoCondition condition);

}
