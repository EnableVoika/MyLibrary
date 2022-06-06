package com.voika.dao.adjust.repository;

import com.voika.controller.adjust.dto.AdjustCondition;
import com.voika.controller.adjust.vo.AdjustInfoVO;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdjustRepository {

    /**
     * 查询 furry_slave 的 TJ 信息
     * @return
     */
    List<AdjustInfoVO> searchAdjustInfo(AdjustCondition condition);

    /**
     * 逻辑删除 TJ 记录
     */
    int deletedAdjustInfo(Integer id);

}
