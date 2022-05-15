package com.equipment.bus.vo;

import com.equipment.bus.entity.Sales;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: bzu
 * @Date: 2021/01/18 10:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SalesVo extends Sales {

    private Integer page = 1;

    private Integer limit = 10;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

}
