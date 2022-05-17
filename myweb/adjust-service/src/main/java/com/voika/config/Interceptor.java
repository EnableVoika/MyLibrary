package com.voika.config;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.voika.enums.AccountEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accountInfo = request.getHeader("token");
        JSONObject entries = JSONUtil.parseObj(accountInfo);
        Map<String,Object> obj = (Map<String, Object>) entries.getObj(accountInfo, HashMap.class);
        System.out.println(obj);
        return true;
    }
}
