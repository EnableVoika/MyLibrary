package com.voika.adjust.controller;

import com.voika.adjust.infrastructure.dto.login.LoginDTO;
import com.voika.adjust.infrastructure.response.JsonResponse;
import com.voika.adjust.infrastructure.response.Response;
import com.voika.adjust.infrastructure.vo.login.LoginVO;
import com.voika.adjust.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping
    public JsonResponse login(@RequestBody LoginDTO dto) {
        LoginVO userObj = loginService.login(dto);
        if (ObjectUtils.isEmpty(userObj)) {
            return Response.error("账号不存在");
        }
        if (userObj.getPassword() == null && dto.getPassword() == userObj.getPassword()) {
            return Response.success("登录成功！",userObj);
        }
        if (dto.getPassword() != null && dto.getPassword().equals(userObj.getPassword())) {
            return Response.success("登录成功！",userObj);
        }
        return Response.error("密码错误");
    }

}
