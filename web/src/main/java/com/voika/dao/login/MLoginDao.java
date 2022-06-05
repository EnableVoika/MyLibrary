package com.voika.dao.login;

import com.voika.controller.login.po.AccountPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MLoginDao {

    /**
     * 用户数据字典
     * @param po
     * @return
     */
    List<AccountPO> accountDir(AccountPO po);

    /**
     * 查询用户对应的角色
     */
    List<String> searchRole(@Param("accountId") Integer accountId);

    /**
     * 查询角色对应的权限
     * @param roleId
     * @return
     */
    List<String> searchPerms(@Param("roleId") Integer roleId);

    List<Integer> roleIds(@Param("accountId") Integer accountId);

}
