package com.voika.adjust.service.impl;

import com.voika.adjust.dao.edgeadjust.mdao.EdgeAdjustDao;
import com.voika.adjust.dao.edgeadjust.po.EdgeAdjustPO;
import com.voika.adjust.service.EdgeAdjustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EdgeAdjustServiceImpl implements EdgeAdjustService {

    @Resource
    private EdgeAdjustDao edgeAdjustDao;

    /**
     * 分页查询边缘调教数据
     * @return
     */
    @Override
    public List<EdgeAdjustPO> queryCondition() {
        return edgeAdjustDao.queryCondition();
    }
}
