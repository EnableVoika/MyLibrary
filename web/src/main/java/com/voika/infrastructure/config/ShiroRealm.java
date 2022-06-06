package com.voika.infrastructure.config;

import cn.hutool.core.collection.CollectionUtil;
import com.voika.dao.login.po.AccountPO;
import com.voika.dao.login.repository.LoginRepository;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Component
//@DependsOn("loginRepositoryImpl")
public class ShiroRealm extends AuthorizingRealm {

    @Resource(name = "loginRepositoryImpl")
    private LoginRepository loginRepository;

    @Resource(name = "stringRedisTemplate")
    private StringRedisTemplate redisTemplate;

    @Override
    public String getName() {
        return "ShiroRealm";
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = loginRepository.searchRole(username);
        Set<String> perms = loginRepository.searchPerms(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 前端传的username
        String username = (String) token.getPrincipal();
        username = StringUtil.isEmpty(username)?"错误，没有用户名":username;
        AccountPO po = AccountPO.builder().username(username).build();
        List<AccountPO> accountList = loginRepository.accountDir(po);
        if (CollectionUtil.isEmpty(accountList)) {
            return null;
        }
        AccountPO account = accountList.get(0);
        if (StringUtil.isEmpty(account.getUsername())) {
            return null;
        }
        String alias = account.getAlias();
        redisTemplate.opsForValue().set(username,"d0g_"+System.currentTimeMillis());
        if (StringUtil.isNotEmpty(alias)) {
            redisTemplate.opsForValue().set(username,alias);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account.getUsername(), account.getPassword(), getName());
        return info;
    }
}
