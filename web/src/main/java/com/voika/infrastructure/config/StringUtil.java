package com.voika.infrastructure.config;

public class StringUtil {

    public static boolean isEmpty(String var) {
        return null == var ? true : var.trim().length() == 0 ? true : "".equals(var) ? true : false;
    }

    public static boolean isNotEmpty(String var) {
        return !isEmpty(var);
    }

    public static boolean isAllEmpty(String... vars) {
        if (vars.length == 0) {
            return true;
        }
        for (String var : vars) {
            // 如果是空，下一个
            if (isEmpty(var)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean isAllNotEmpty(String... vars) {
        if (vars.length == 0) {
            return false;
        }
        for (String var : vars) {
            if (isEmpty(var)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyEmpty(String... vars) {
        if (vars.length == 0) {
            return true;
        }
        for (String var : vars) {
            if (isEmpty(var)) {
                return true;
            }
        }
        return false;
    }

}
