package com.voika.adjust.dao.mdao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.AdjustVO;

import java.util.List;

public interface AdjustDao extends BaseMapper<Object> {

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
