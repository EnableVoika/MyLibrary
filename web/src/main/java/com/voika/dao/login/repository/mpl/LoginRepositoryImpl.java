package com.voika.dao.login.repository.mpl;

import com.voika.dao.login.mapper.LoginMapper;
import com.voika.dao.login.po.AccountPO;
import com.voika.dao.login.repository.LoginRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Resource
    private LoginMapper loginMapper;

    /**
     * 获取用户身份信息
     * @param po
     * @return
     */
    @Override
    public AccountPO getAccountInfo(AccountPO po) {
        return loginMapper.getAccountInfo(po);
    }
}
