package com.voika.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.equals("") || str.trim().length() == 0)
            return true;
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
