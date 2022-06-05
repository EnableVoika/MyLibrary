package com.voika.controller.adjust.dto;

import lombok.Data;

@Data
public class AdjustCondition {

    private int pageNum;
    private int pageSize;
    private String adjustedDog;
    private Integer adjustContentCode;
    private String adjustInfo;
    private Integer effectiveness;
    private String adjustDatetimeStart;
    private String adjustDatetimeEnd;

}
