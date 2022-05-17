package com.voika.infrastructure.util.enums;

public enum AdjustInfoEnum {

    DELETED(1,"删除"),UNDELETED(0,"未删除"),
    EFFECTIVENESS(1,"有效"),UNEFFECTIVENESS(0,"无效");

    private Integer code;
    private String value;

    public Integer getCode() {
        return this.code;
    }
    public String getValue() {
        return this.value;
    }

    AdjustInfoEnum(Integer code,String value) {
        this.code = code;
        this.value = value;
    }
}
