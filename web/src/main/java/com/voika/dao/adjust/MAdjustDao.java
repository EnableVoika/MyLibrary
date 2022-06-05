package com.voika.dao.adjust;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;

import java.util.List;

public interface MAdjustDao {

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */
    List<AdjustInfoVO> searchAdjustInfo(AdjustCondition condition);

}
