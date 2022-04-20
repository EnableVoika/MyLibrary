package com.voika.adjust.infrastructure;

import lombok.Data;

@Data
public class BasePO {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 修改的时间
     */
    private String modifyTime;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建者名字
     */
    private String creatorName;

    /**
     * 是否被删除
     * 1：是
     * 0：否
     */
    private Integer deleted;

    /**
     * 乐观锁版本号
     */
    private Integer version;

}
