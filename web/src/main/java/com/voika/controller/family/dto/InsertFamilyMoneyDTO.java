package com.voika.controller.family.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InsertFamilyMoneyDTO {

    private String personName;
    private BigDecimal money;
    private Integer moneyStatus;
    private String remark;
    private String saveTime;

}
