package com.voika.adjust.service.impl;

import com.voika.adjust.dao.mdao.AdjustDao;
import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.AdjustVO;
import com.voika.adjust.service.EdgeAdjustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EdgeAdjustServiceImpl implements EdgeAdjustService {

    @Resource
    private AdjustDao edgeAdjustDao;

    /**
     * 分页查询边缘调教数据
     * @return
     */
    @Override
    public List<AdjustVO> queryCondition(AdjustCondition condition) {
        return edgeAdjustDao.queryCondition(condition);
    }

    /**
     * 插入调教记录
     * @param po
     * @return
     */
    @Override
    public int insertAdjustInfo(AdjustPO po) {
        return edgeAdjustDao.insertAdjustInfo(po);
    }
}
