package com.etoak.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("movies")
public class Movie extends Vo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String direct;
    private String protagonist;
    private String type;
    private String region;
    private String language;
    private String releaseDateStr;
    private String date;
    private Integer status;
    private String path;


}
