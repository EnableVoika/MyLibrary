package com.equipment.sys.vo;

import com.equipment.sys.entity.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: bzu
 * @Date: 2020/11/22 15:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionVo extends Permission {

    private Integer page=1;
    private Integer limit=10;
}
