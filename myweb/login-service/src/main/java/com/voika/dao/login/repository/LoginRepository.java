package com.voika.dao.login.repository;

import com.voika.dao.login.po.AccountPO;

public interface LoginRepository {

    // 获取用户身份信息
    AccountPO getAccountInfo(AccountPO po);

}
