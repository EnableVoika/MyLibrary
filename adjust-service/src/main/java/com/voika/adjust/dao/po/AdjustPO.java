package com.voika.adjust.dao.po;

import com.voika.adjust.infrastructure.BasePO;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class AdjustPO extends BasePO {

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

    @Override
    public int hashCode() {
        return adjustedDog.hashCode() + adjustContentCode +
                adjustInfo.hashCode() + adjustCount + adjustDatetime.hashCode();
    }


    public AdjustPO init() {
        this.adjustContentCode = 1;
        this.adjustedDog = "翊";
        this.adjustCount = 0;
        this.adjustDatetime =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.adjustInfo = "日常完成主子的调教任务";
        return this;
    }

}
