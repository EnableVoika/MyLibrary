package com.voika.adjust.service.impl;

import com.voika.adjust.dao.mdao.AdjustDao;
import com.voika.adjust.dao.po.AdjustCodeAndValue;
import com.voika.adjust.dao.po.AdjustCondition;
import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.adjust.AdjustVO;
import com.voika.adjust.service.AdjustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdjustServiceImpl implements AdjustService {

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

    /**
     * 逻辑删除调教记录
     * @param id
     * @return
     */
    @Override
    public int delAdjustInfo(int id) {
        return edgeAdjustDao.delAdjustInfo(id);
    }

    /**
     * 更新狗子调教记录
     * @param po
     * @return
     */
    @Override
    public int updateAdjustInfoById(AdjustPO po) {
        return edgeAdjustDao.updateAdjustInfoById(po);
    }

    /**
     * 获得调教code和value
     * @return
     */
    @Override
    public List<AdjustCodeAndValue> getCodeList() {
        return edgeAdjustDao.getCodeList();
    }
}
