package com.voika.infrastructure.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.voika.controller.login.po.AccountPO;
import com.voika.dao.login.repository.LoginRepository;
import com.voika.service.login.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Component
//@DependsOn("loginRepositoryImpl")
public class ShiroRealm extends AuthorizingRealm {

    @Resource(name = "loginRepositoryImpl")
    private LoginRepository loginRepository;

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
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account.getUsername(), account.getPassword(), getName());
        return info;
    }
}
