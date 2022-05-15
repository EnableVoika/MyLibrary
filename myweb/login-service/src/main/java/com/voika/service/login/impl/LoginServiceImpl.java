package com.voika.service.login.impl;

import com.voika.dao.login.po.AccountPO;
import com.voika.dao.login.repository.LoginRepository;
import com.voika.service.login.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginRepository loginRepository;

    /**
     * 获取用户身份信息
     */
    @Override
    public AccountPO getAccountInfo(AccountPO po) {
        return loginRepository.getAccountInfo(po);
    }
}
