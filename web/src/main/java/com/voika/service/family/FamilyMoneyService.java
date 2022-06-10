package com.voika.service.family;

import cn.hutool.core.bean.BeanUtil;
import com.voika.controller.family.dto.InsertFamilyMoneyDTO;
import com.voika.controller.family.dto.SearchFamilyMoneyDTO;
import com.voika.controller.family.vo.FamilyMoneyVO;
import com.voika.dao.family.po.FamilyMoneyPO;
import com.voika.dao.family.repository.FamilyMoneyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class FamilyMoneyService {

    @Resource(name = "familyMoneyRepositoryImpl")
    private FamilyMoneyRepository familyMoneyRepository;

    /**
     * 分页查询资金收入情况
     * @param dto
     * @return
     */
    public List<FamilyMoneyVO> searchCondition(SearchFamilyMoneyDTO dto) {
        List<FamilyMoneyVO> pojo = familyMoneyRepository.searchCondition(dto);
        pojo.forEach(x -> {
            if (Integer.valueOf(1).equals(x.getMoneyStatus())) {
                x.setMoneyStatusName("收入");
            }else if (Integer.valueOf(-1).equals(x.getMoneyStatus())) {
                x.setMoneyStatusName("支出");
            }
        });
        return pojo;
    }

    /**
     *
     * @param dto
     * @return
     */
    public int insertFamilyMoney(InsertFamilyMoneyDTO dto) {
        BigDecimal money = dto.getMoney();
        if (Integer.valueOf(-1) == dto.getMoneyStatus()) {
            dto.setMoney(money.negate());
        }
        FamilyMoneyPO po = new FamilyMoneyPO();
        BeanUtil.copyProperties(dto,po);
        return familyMoneyRepository.insertFamilyMoney(po);
    }

}
