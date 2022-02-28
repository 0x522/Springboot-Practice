package com.lwc.admin.util;

import java.util.Date;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

public class DateUnit {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyyMMdd",
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"
    };

    /**
     * 转时间类型
     *
     * @param
     * @return
     */
    /**
     * 转时间类型
     *
     * @param time 时间字符串
     * @return
     */
    public static Date toDate(String time) {
        if (!StringUtils.isEmptyOrNull(time)) {
            try {
                return parseDate(time, parsePatterns);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }

    }

}
