package com.voika.adjust.service;

import com.voika.adjust.dao.po.AdjustCodeAndValue;
import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.adjust.AdjustVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdjustService {

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

    /**
     * 逻辑删除调教记录
     * @param id
     * @return
     */
    int delAdjustInfo(int id);

    /**
     * 更新狗子调教记录
     * @param po
     * @return
     */
    int updateAdjustInfoById(AdjustPO po);

    /**
     * 获得调教code和value
     * @return
     */
    List<AdjustCodeAndValue> getCodeList();


}
