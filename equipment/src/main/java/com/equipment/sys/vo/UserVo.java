package com.equipment.sys.vo;

import com.equipment.sys.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: bzu
 * @Date: 2021/01/2 8:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends User {

    private Integer page=1;
    private Integer limit=10;

    /**
     * 验证码
     */
    private String code;
}
