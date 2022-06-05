package com.voika.controller.login.po;

import lombok.Data;

import java.util.List;

@Data
public class RolePerms {
    private Integer roleId;
    private String roleName;
    private Integer permId;
    private String permName;

}
