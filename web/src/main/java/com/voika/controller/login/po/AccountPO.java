package com.voika.controller.login.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountPO {

    private Integer id;
    private String username;
    private String password;
    private Integer accountStatus;
    private Integer deleted;

}
