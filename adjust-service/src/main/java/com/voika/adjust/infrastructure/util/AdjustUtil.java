package com.voika.adjust.infrastructure.util;

import com.voika.adjust.dao.po.AdjustPO;
import com.voika.adjust.infrastructure.vo.adjust.AdjustVO;
import org.springframework.util.ObjectUtils;

public class AdjustUtil {

    /**
     * 解析调教码
     * @param vo
     */
    public static void parseAdjustCode(AdjustVO vo) {
        if (ObjectUtils.isEmpty(vo) || null == vo.getAdjustContentCode()) {
            return;
        }
        if (vo.getAdjustContentCode() % 2 == 0) {
            if (vo.getAdjustContentCode() == 2) {
                vo.setAdjustContent("捶蛋");
            }else if (vo.getAdjustContentCode() == 4) {
                vo.setAdjustContent("狗姿撒尿");
            }else if (vo.getAdjustContentCode() == 6) {
                vo.setAdjustContent("憋尿");
            }else if (vo.getAdjustContentCode() == 8) {
                vo.setAdjustContent("龟头责");
            }else if (vo.getAdjustContentCode() == 10) {
                vo.setAdjustContent("");
            }
        }else {
            if (vo.getAdjustContentCode() == 1) {
                vo.setAdjustContent("边缘调教");
            }else if (vo.getAdjustContentCode() == 3) {
                vo.setAdjustContent("野裸");
            }else if (vo.getAdjustContentCode() == 5) {
                vo.setAdjustContent("榨精");
            }else if (vo.getAdjustContentCode() == 7) {
                vo.setAdjustContent("尿道开发");
            }else if (vo.getAdjustContentCode() == 9) {
                vo.setAdjustContent("屁眼开发");
            }
        }
    }

    public static void initAdjustBaseField(Object obj) {
        if (obj instanceof AdjustPO) {
        }
    }

}
