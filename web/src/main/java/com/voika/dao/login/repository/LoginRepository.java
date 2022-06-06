package com.voika.dao.login.repository;

import com.voika.dao.login.po.AccountPO;

import java.util.List;
import java.util.Set;

public interface LoginRepository {

    /**
     * 用户数据字典
     * @param po
     * @return
     */
    List<AccountPO> accountDir(AccountPO po);

    /**
     * 查询用户对应的角色
     */
    Set<String> searchRole(Integer accountId);
    Set<String> searchRole(String username);

    /**
     * 查询角色对应的权限
     * @param roleId
     * @return
     */
    Set<String> searchPerms(Integer roleId);
    Set<String> searchPerms(String username);

    Set<Integer> roleIds(Integer accountId);

}
