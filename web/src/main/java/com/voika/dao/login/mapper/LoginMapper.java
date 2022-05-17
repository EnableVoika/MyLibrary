package com.voika.dao.login.mapper;

import com.voika.dao.login.po.AccountPO;

public interface LoginMapper {

    AccountPO getAccountInfo(AccountPO po);

}
