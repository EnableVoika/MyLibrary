package com.voika.controller.login;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.voika.controller.login.dto.AccountDTO;
import com.voika.dao.login.po.AccountPO;
import com.voika.infrastructure.util.entity.JsonData;
import com.voika.infrastructure.util.enums.AccountEnum;
import com.voika.service.login.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping
    public JsonData login(@RequestBody AccountDTO dto) {
        AccountPO accountPO = new AccountPO();
        BeanUtil.copyProperties(dto, accountPO);
        AccountPO accountInfo = loginService.getAccountInfo(accountPO);
        if (ObjectUtil.isEmpty(accountInfo)) {
            return JsonData.error("账号不存在");
        }

        if (AccountEnum.DISABLE.getCode().equals(accountInfo.getAccountStatus())) {
            return JsonData.error(50001,"该账号已被禁用");
        }

        String password = accountInfo.getPassword();
        password = password == null ? "" : password;
        if (!password.equals(dto.getPassword())) {
            return JsonData.error("密码错误");
        }
        return JsonData.success("登录成功", accountInfo);
    }

}
