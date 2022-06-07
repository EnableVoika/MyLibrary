package com.voika.infrastructure;

import com.voika.infrastructure.config.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class ControllerExceltionHandler {

    @ExceptionHandler(AuthorizationException.class)
    public JsonData noAuth(AuthorizationException e, HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        if (requestURI.contains("furry"))
//            return JsonData.noAuth("您还不是furry，没有权限进行此操作");
        log.warn("AuthorizationException 的异常信息 ====> ["+e.getMessage()+"]");
        if (StringUtil.isNotEmpty(e.getMessage())) {
            if (e.getMessage().contains("Subject does not have role [furry:master]")) {
                if ("luni".equals(getUsername())) {
                    return JsonData.noAuth("你不是国王陛下，你无权控制魔王龙");
                }
                if ("sin".equals(getUsername())) {
                    return JsonData.noAuth("你不是sin主人，你无权这么做");
                }
            }
        }
        return JsonData.noAuth("您没有权限进行此操作");
    }

    @ExceptionHandler({UnknownAccountException.class})
    public JsonData noAccount(UnknownAccountException e) {
        log.warn("UnknownAccountException 的异常信息 ====> ["+e.getMessage()+"]");
        return JsonData.noAccount();
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public JsonData errorPwd(IncorrectCredentialsException e) {
        log.warn("IncorrectCredentialsException 的异常信息 ====> ["+e.getMessage()+"]");
        return JsonData.errorPwd("请检查密码是否正确");
    }

    @ExceptionHandler({Exception.class})
    public JsonData handler(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.warn("请求地址", requestURI);
        log.warn("异常信息", e);
        return JsonData.noAuth("未知异常");
    }

    private Subject getSub() {
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
    private String getUsername() {
        String username = (String) getSub().getPrincipal();
        return username;
    }

}
