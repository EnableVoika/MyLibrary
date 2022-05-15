package com.voika.service.impl;

import com.voika.controller.dto.AdjustInfoCondition;
import com.voika.controller.vo.AdjustInfoVO;
import com.voika.dao.po.AdjustInfoPO;
import com.voika.dao.repository.AdjustRepository;
import com.voika.service.AdjustService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdjustServiceImpl implements AdjustService {

    @Resource
    private AdjustRepository adjustRepository;

    /**
     * 分页查询调教记录
     * @param condition
     * @return
     */
    @Override
    public List<AdjustInfoVO> searchAdjustInfo(AdjustInfoCondition condition) {
        return adjustRepository.searchAdjustInfo(condition);
    }
}
