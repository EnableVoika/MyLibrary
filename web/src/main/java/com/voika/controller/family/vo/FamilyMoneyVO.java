package com.voika.controller.family.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FamilyMoneyVO {

    private Long id;
    private String personName;
    private BigDecimal money;
    private Integer moneyStatus;
    private String moneyStatusName;
    private String remark;
    private String saveTime;
    private String createTime;
    private String modyfiTime;
    private String createName;
    private String operatorName;
    private Integer deleted;

}
