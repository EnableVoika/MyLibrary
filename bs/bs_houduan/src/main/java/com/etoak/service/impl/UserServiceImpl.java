package com.etoak.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.etoak.entity.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id","username","password","role").eq("username",user.getUsername());
        return userMapper.selectOne(queryWrapper);
    }
}
