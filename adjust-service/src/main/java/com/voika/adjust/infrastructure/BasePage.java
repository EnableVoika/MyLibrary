package com.voika.adjust.infrastructure;

import lombok.Data;

@Data
public class BasePage {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalRows;

}
