package com.voika.controller.adjust.vo;

import lombok.Data;

@Data
public class AdjustInfoVO {

    private int id;
    private String adjustedDog;
    private Integer adjustContentCode;
    private String adjustContentValue;
    private String adjustInfo;
    private Integer adjustCount;
    private Integer effectiveness;
    private String effectivenessValue;
    private String adjustDatetime;

    public void parse() {
        switch (this.getAdjustContentCode()) {
            case 1 : this.setAdjustContentValue("边缘调教");break;
            case 2 : this.setAdjustContentValue("捶蛋");break;
            case 3 : this.setAdjustContentValue("野裸");break;
            case 4 : this.setAdjustContentValue("狗姿撒尿");break;
            case 5 : this.setAdjustContentValue("榨精");break;
            case 6 : this.setAdjustContentValue("憋尿");break;
            case 7 : this.setAdjustContentValue("尿道开发");break;
            case 8 : this.setAdjustContentValue("龟头责");break;
            case 9 : this.setAdjustContentValue("屁眼开发");break;
        }
        switch (this.getEffectiveness()) {
            case 1 : this.setEffectivenessValue("有效");break;
            case 0 : this.setEffectivenessValue("无效");break;
        }
    }

}
