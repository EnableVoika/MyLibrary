package com.voika.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ControllerExceltionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public JsonData noAuth(AuthorizationException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("furry"))
            return JsonData.noAuth("您还不是furry，没有权限进行此操作");
        return JsonData.noAuth("您没有权限进行此操作");
    }

    @ExceptionHandler({UnknownAccountException.class})
    public JsonData noAccount() {
        return JsonData.noAccount();
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public JsonData errorPwd() {
        return JsonData.errorPwd("请检查密码是否正确");
    }

    @ExceptionHandler({Exception.class})
    public JsonData handler(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.info("请求地址",requestURI);
        log.info("异常信息",e);
        return JsonData.noAuth("未知异常");
    }

}
