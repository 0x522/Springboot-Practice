package com.lwc.admin.util;

import static com.alibaba.druid.util.StringUtils.isEmpty;

public class StringUtils {

    public static boolean isEmptyOrNull(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
