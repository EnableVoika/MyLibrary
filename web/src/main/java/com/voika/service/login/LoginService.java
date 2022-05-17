package com.voika.service.login;

import com.voika.dao.login.po.AccountPO;

public interface LoginService {

    /**
     * 获取用户身份信息
     */
    AccountPO getAccountInfo(AccountPO po);

}
