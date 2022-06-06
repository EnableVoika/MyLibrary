package com.voika.controller.login;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import com.voika.controller.login.dto.AccountDTO;
import com.voika.infrastructure.JsonData;
import com.voika.infrastructure.config.StringUtil;
import com.voika.service.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @PostMapping
    public JsonData login(@RequestBody AccountDTO dto) {
        if (StringUtil.isAnyEmpty(dto.getUsername(), dto.getPassword())) {
            return JsonData.error("用户名或密码不能为空");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(dto.getUsername(), dto.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        String msg = "欢迎回来,";
//        if ("luni".equals(dto.getUsername())) {
//            msg = "检测到是陛下，欢迎回来，高贵的国王陛下";
//        }
        String alias = redisTemplate.opsForValue().get(dto.getUsername());
        msg += alias;
        Set<String> roles = loginService.searchAccountRoles(dto.getUsername());
        Serializable sessionId = subject.getSession().getId();
        Map<String, Object> resp = new HashMap<String, Object>() {{
            put("token", sessionId);
            put("roles", roles);
            put("alias", alias);
        }};
        return JsonData.success(msg, resp);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @GetMapping("/loginout")
    public JsonData loginOut() {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        String alias = redisTemplate.opsForValue().get(username);
        subject.logout();
        return JsonData.success(alias + "已退出登录");
    }

}
