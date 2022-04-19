package com.voika.adjust.dao.edgeadjust.mdao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.voika.adjust.dao.edgeadjust.po.EdgeAdjustPO;

import java.util.List;

public interface EdgeAdjustDao extends BaseMapper<Object> {

    /**
     * 分页查询边缘调教数据
     * @return
     */
    List<EdgeAdjustPO> queryCondition();

}
