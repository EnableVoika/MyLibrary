package com.voika.dao.login.repository.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.voika.controller.login.po.AccountPO;
import com.voika.dao.login.MLoginDao;
import com.voika.dao.login.repository.LoginRepository;
import com.voika.infrastructure.config.StringUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    @Resource
    private MLoginDao loginDao;

    /**
     * 用户数据字典
     *
     * @param po
     * @return
     */
    @Override
    public List<AccountPO> accountDir(AccountPO po) {
        return loginDao.accountDir(po);
    }

    /**
     * 查询用户对应的角色
     */
    @Override
    public Set<String> searchRole(Integer accountId) {
        List<String> vars = loginDao.searchRole(accountId);
//        Set<String> roles = new HashSet<>();
//        for (String var : vars) {
//            roles.add(var);
//        }
        return CollectionUtil.isEmpty(vars)?new HashSet<>():vars.stream().collect(Collectors.toSet());
    }

    /**
     * 查询用户对应的角色
     */
    @Override
    public Set<String> searchRole(String username) {
        AccountPO po = AccountPO.builder().username(StringUtil.isEmpty(username) ? "错误，没有用户名" : username).build();
        List<AccountPO> accounts = accountDir(po);
        List<String> vars = loginDao.searchRole(CollectionUtil.isNotEmpty(accounts) ? accounts.get(0).getId() : -1);
//        Set<String> roles = new HashSet<>();
//        for (String var : vars) {
//            roles.add(var);
//        }
        return CollectionUtil.isEmpty(vars)?new HashSet<>():vars.stream().collect(Collectors.toSet());
    }


    /**
     * 查询角色对应的权限
     *
     * @param roleId
     * @return
     */
    @Override
    public Set<String> searchPerms(Integer roleId) {
        //Set<String> perms = new HashSet<>();
        List<String> vars = loginDao.searchPerms(roleId);
//        for (String var : vars) {
//            perms.add(var);
//        }

        return CollectionUtil.isEmpty(vars)?new HashSet<>():vars.stream().collect(Collectors.toSet());
    }
    @Override
    public Set<String> searchPerms(String username) {
        AccountPO po = AccountPO.builder().username(StringUtil.isEmpty(username) ? "错误，没有用户名" : username).build();
        List<AccountPO> accounts = accountDir(po);
        Set<String> perms = new HashSet<>();
        if (CollectionUtil.isNotEmpty(accounts)) {
            Integer id = accounts.get(0).getId();
            Set<Integer> roleIds = roleIds(id);
            for (Integer roleId : roleIds) {
                List<String> vars = loginDao.searchPerms(roleId);
                for (String var : vars) {
                    perms.add(var);
                }
            }
        }
        return perms;
    }

    @Override
    public Set<Integer> roleIds(Integer accountId) {
        List<Integer> vars = loginDao.roleIds(accountId);
//        Set<Integer> perms = new HashSet<>();
//        for (Integer var : vars) {
//            perms.add(var);
//        }
        return CollectionUtil.isEmpty(vars)?new HashSet<>():vars.stream().collect(Collectors.toSet());
    }

}
