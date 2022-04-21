package com.voika.adjust.infrastructure.vo.login;

import lombok.Data;

@Data
public class LoginVO {

    private Integer id;
    private String username;
    private String password;
    /**
     * 身份，0是狗子还,1是主人
     */
    private Integer role;
    /**
     * 身份，是狗子还是主人的汉字描述
     */
    private String identy;

}
