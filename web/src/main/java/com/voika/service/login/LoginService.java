package com.voika.service.login;

import cn.hutool.core.bean.BeanUtil;
import com.voika.controller.login.dto.AccountDTO;
import com.voika.dao.login.po.AccountPO;
import com.voika.dao.login.repository.LoginRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class LoginService {

    @Resource(name = "loginRepositoryImpl")
    private LoginRepository loginRepository;

    /**
     * 用户数据字典
     */
    public List<AccountPO> accountDir(AccountDTO dto) {
        AccountPO po = new AccountPO();
        BeanUtil.copyProperties(dto,po);
        return loginRepository.accountDir(po);
    }

    /**
     * 查询用户对应的角色
     */
    public Set<String> searchAccountRoles(String username) {
        return loginRepository.searchRole(username);
    }

}
