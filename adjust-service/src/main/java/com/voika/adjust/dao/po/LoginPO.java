package com.voika.adjust.dao.po;

import com.voika.adjust.infrastructure.BasePO;
import lombok.Data;

@Data
public class LoginPO extends BasePO {

    private String username;
    private String password;
    private Integer role;

}
