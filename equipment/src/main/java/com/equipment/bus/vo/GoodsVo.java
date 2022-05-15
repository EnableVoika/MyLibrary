package com.equipment.bus.vo;

import com.equipment.bus.entity.Goods;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: bzu
 * @Date: 2021/01/6 22:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsVo extends Goods {

    private Integer page=1;
    private Integer limit=10;

}
