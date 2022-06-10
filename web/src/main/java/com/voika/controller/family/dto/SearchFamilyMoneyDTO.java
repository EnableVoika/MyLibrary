package com.voika.controller.family.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SearchFamilyMoneyDTO {

    // 成员名字
    private String personName;
    // 金额
    private BigDecimal money;
    // 收入/支出 状态
    private Integer moneyStatus;
    // 备注
    private String remark;
    // 存入时间开始
    private String saveInTimeStart;
    // 存入时间结束
    private String saveInTimeEnd;

}
