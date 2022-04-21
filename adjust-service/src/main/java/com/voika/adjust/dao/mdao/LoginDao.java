package com.voika.adjust.dao.mdao;

import com.voika.adjust.dao.po.LoginPO;
import com.voika.adjust.infrastructure.vo.login.LoginVO;

public interface LoginDao {

    /**
     * 登录
     */
    LoginVO login(LoginPO po);

}
