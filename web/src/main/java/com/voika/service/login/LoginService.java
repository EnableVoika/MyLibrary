package com.voika.service.login;

import cn.hutool.core.bean.BeanUtil;
import com.voika.controller.login.dto.AccountDTO;
import com.voika.controller.login.po.AccountPO;
import com.voika.dao.login.MLoginDao;
import com.voika.dao.login.repository.LoginRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {

    @Resource
    private LoginRepository loginRepository;

    /**
     * 用户数据字典
     */
    public List<AccountPO> accountDir(AccountDTO dto) {
        AccountPO po = new AccountPO();
        BeanUtil.copyProperties(dto,po);
        return loginRepository.accountDir(po);
    }

}
