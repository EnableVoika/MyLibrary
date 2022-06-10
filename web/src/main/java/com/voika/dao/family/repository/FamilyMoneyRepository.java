package com.voika.dao.family.repository;

import com.voika.controller.family.dto.SearchFamilyMoneyDTO;
import com.voika.controller.family.vo.FamilyMoneyVO;
import com.voika.dao.family.po.FamilyMoneyPO;

import java.util.List;

public interface FamilyMoneyRepository {

    /**
     * 分页查询资金收入情况
     * @param dto
     * @return
     */
    List<FamilyMoneyVO> searchCondition(SearchFamilyMoneyDTO dto);

    /**
     * 插入资金记录
     */
    int insertFamilyMoney(FamilyMoneyPO po);

}
