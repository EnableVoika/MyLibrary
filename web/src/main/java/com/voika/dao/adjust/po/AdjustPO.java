package com.voika.dao.adjust.po;

import lombok.Data;

@Data
public class AdjustPO {

    private int id;
    private String adjustedDog;
    private Integer adjustContentCode;
    private String adjustInfo;
    private Integer adjustCount;
    private Integer effectiveness;
    private String adjustDatetime;
    private Integer deleted;

}
