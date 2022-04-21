package com.voika.adjust.service;

import com.voika.adjust.dao.po.LoginPO;
import com.voika.adjust.infrastructure.dto.login.LoginDTO;
import com.voika.adjust.infrastructure.vo.login.LoginVO;

public interface LoginService {

    /**
     * 登录
     */
    LoginVO login(LoginDTO dto);

}
