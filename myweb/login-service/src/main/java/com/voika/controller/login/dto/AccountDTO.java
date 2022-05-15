package com.voika.controller.login.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Integer id;

    private String username;

    private String password;

    /**
     * 权限、身份
     */
    private Integer role;

    /**
     * 账户状态，1：启用；2：禁用
     */
    private Integer accountStatus;

}
