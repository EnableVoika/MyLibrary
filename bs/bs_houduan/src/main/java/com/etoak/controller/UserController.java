package com.etoak.controller;

import com.alibaba.fastjson.JSON;
import com.etoak.entity.User;
import com.etoak.service.UserService;
import com.etoak.utils.JsonResponse;
import com.etoak.utils.ResultStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.UUID;

@RequestMapping("user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate template;

    @PostMapping
    public JsonResponse getUser(@RequestBody User user) throws FileNotFoundException {

        User data  = userService.getUser(user);
        if(data == null) {
            return ResultStatus.error("用户名或密码错误");
        }
        if(!"".equals(data.getPassword()) && !(data.getPassword().equals(user.getPassword())))
            return ResultStatus.error("用户名或密码错误");
        String token = JSON.toJSONString(user);
        template.opsForValue().set(user.getUsername(),token);
        log.info("token={}",token);
        return ResultStatus.suc("登录成功！",data);
    }

}
