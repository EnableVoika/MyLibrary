package com.voika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

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

    /**
     * 是否删除，0：未删除；1：删除
     */
    private Integer deleted;

}
