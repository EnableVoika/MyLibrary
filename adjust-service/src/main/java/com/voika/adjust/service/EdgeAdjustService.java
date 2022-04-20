package com.voika.adjust.service;

import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.AdjustVO;

import java.util.List;

public interface EdgeAdjustService {

    /**
     * 分页查询边缘调教数据
     * @return
     */
    List<AdjustVO> queryCondition(AdjustCondition condition);

    /**
     * 插入调教记录
     * @param po
     * @return
     */
    int insertAdjustInfo(AdjustPO po);

}