package com.voika.dao.po;

import lombok.Data;

@Data
public class AdjustInfoPO {

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
