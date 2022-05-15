package com.equipment.sys.vo;

import com.equipment.sys.entity.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: bzu
 * @Date: 2020/11/26 11:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends Dept {

    private Integer page=1;
    private Integer limit=10;

}
