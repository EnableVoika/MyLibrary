package com.etoak.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("review")
public class ReView extends Vo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String ftimeStr;
    private String content;

}
