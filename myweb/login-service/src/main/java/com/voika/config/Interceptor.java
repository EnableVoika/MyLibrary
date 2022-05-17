package com.voika.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.voika.util.StringUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class Interceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String accountInfo = request.getHeader("token");
//        if (StringUtil.isEmpty(accountInfo)) {
//            response.setStatus(50000);
//            Map<String,Object> data = new HashMap<String,Object>(){{
//                put("code",50000);
//                put("msg","没有token");
//                put("data",null);
//                put("status",false);
//            }};
//            String dataJson = JSON.toJSONString(data);
//            response.setContentType("application/json");
//            PrintWriter out = response.getWriter();
//            out.println(dataJson);
//            out.close();
//            return false;
//        }
        return true;
    }
}
