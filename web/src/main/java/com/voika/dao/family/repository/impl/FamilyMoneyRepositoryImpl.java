package com.voika.dao.family.repository.impl;

import cn.hutool.core.collection.CollUtil;
import com.voika.controller.family.dto.SearchFamilyMoneyDTO;
import com.voika.controller.family.vo.FamilyMoneyVO;
import com.voika.dao.family.MFamilyMoneyDao;
import com.voika.dao.family.po.FamilyMoneyPO;
import com.voika.dao.family.repository.FamilyMoneyRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FamilyMoneyRepositoryImpl implements FamilyMoneyRepository {

    @Resource
    private MFamilyMoneyDao mFamilyMoneyDao;

    /**
     * 分页查询资金收入情况
     * @param dto
     * @return
     */
    @Override
    public List<FamilyMoneyVO> searchCondition(SearchFamilyMoneyDTO dto) {
        List<FamilyMoneyVO> pojo = mFamilyMoneyDao.searchCondition(dto);
        return CollUtil.isEmpty(pojo) ? new ArrayList<>() : pojo;
    }

    /**
     * 插入资金记录
     */
    @Override
    public int insertFamilyMoney(FamilyMoneyPO po) {
        return mFamilyMoneyDao.insertFamilyMoney(po);
    }
}
