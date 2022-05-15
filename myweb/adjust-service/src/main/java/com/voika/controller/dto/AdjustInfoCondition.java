package com.voika.controller.dto;

import lombok.Data;

@Data
public class AdjustInfoCondition {

    private Integer pageNum;
    private Integer pageSize;
    private Integer role;
    private Integer id;
    private String adjustedDog;
    private Integer adjustContentCode;
    private String adjustInfo;
    private Integer adjustCount;
    // 这条记录是否有效，用于审批环节
    private Integer effectiveness;
    private String adjustDatetime;
    private Integer deleted;

}
