package com.etoak.entity;

import lombok.Data;

import java.util.List;

@Data
public class Vo {
    private Integer page;
    private Integer itemsPerPage;
    private String startDate;
    private String endDate;
    private Integer total;
    private String typeList;
    /** 评论中的用户名 */
    private String name;
    /** 电影id */
    private Integer mid;
}
