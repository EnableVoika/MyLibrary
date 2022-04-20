package com.voika.adjust.dao.po;

import com.voika.adjust.infrastructure.BasePage;
import lombok.Data;

@Data
public class AdjustCondition extends BasePage {

    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 被命令调教的狗名字
     */
    private String adjustedDog;

    /**
     * 调教的内容目前：
     * 1：边缘调
     * 2：捶蛋
     * 3：野裸
     * 4：狗姿撒尿
     * 5：榨精
     * 6：憋尿
     * 7：尿道开发
     * 8：龟头责
     * 9：屁眼开发
     */
    private Integer adjustContentCode;

    /**
     * 调教内容的任务详细报告
     */
    private String adjustInfo;

    /**
     * 调教执行了多少次
     */
    private Integer adjustCount;

    /**
     * 调教执行时当时的时间
     */
    private String adjustDatetime;

    /**
     * 调教时间区间
     */
    private String adjustStartDatetime;
    private String adjustEndDatetime;

}
