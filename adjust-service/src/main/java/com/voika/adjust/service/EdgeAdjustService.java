package com.voika.adjust.service;

import com.voika.adjust.dao.edgeadjust.po.EdgeAdjustPO;

import java.util.List;

public interface EdgeAdjustService {

    /**
     * 分页查询边缘调教数据
     * @return
     */
    List<EdgeAdjustPO> queryCondition();

}
