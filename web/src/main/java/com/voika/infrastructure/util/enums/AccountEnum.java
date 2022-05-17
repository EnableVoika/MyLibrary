package com.voika.infrastructure.util.enums;

import lombok.Data;

public enum AccountEnum {
    DISABLE(0,"禁用"),
    enable(1,"启用");


    private Integer code;
    private String value;
    public Integer getCode() {
        return this.code;
    }
    public String getValue() {
        return this.value;
    }
    AccountEnum(Integer code,String value) {
        this.code = code;
        this.value = value;
    }

}
