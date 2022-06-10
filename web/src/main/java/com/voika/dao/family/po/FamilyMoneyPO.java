package com.voika.dao.family.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FamilyMoneyPO {

    private Long id;
    private String personName;
    private BigDecimal money;
    private Integer moneyStatus;
    private String remark;
    private String saveTime;
    private String createTime;
    private String modyfiTime;
    private String createName;
    private String operatorName;
    private Integer deleted;

}
