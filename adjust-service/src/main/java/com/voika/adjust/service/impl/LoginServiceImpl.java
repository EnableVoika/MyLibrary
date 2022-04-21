package com.voika.adjust.service.impl;

import com.voika.adjust.dao.mdao.LoginDao;
import com.voika.adjust.dao.po.LoginPO;
import com.voika.adjust.infrastructure.dto.login.LoginDTO;
import com.voika.adjust.infrastructure.vo.login.LoginVO;
import com.voika.adjust.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;


    /**
     * 登录
     */
    @Override
    public LoginVO login(LoginDTO dto) {
        LoginPO po = new LoginPO();
        BeanUtils.copyProperties(dto,po);
        return loginDao.login(po);
    }

}
