package com.voika.controller.vo;

import lombok.Data;

@Data
public class AdjustInfoVO {

    private Integer pageNum;
    private Integer pageSize;
    private Long totalRows;
    private Integer id;
    private String adjustedDog;
    private Integer adjustContentCode;
    private String content;
    private String adjustInfo;
    private Integer adjustCount;
    // 这条记录是否有效，用于审批环节
    private Integer effectiveness;
    private String effectivenessValue;
    private String adjustDatetime;
    private Integer deleted;
    private String deletedValue;

}
