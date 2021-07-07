package com.huan.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Author YueDong Huan
 * @Date 2021/7/7
 * @Email huanyued@163.com
 */
public class DateUtil {

    //获取年月日 例：20010101
    public static String getDays() {
        return formatDate(new Date(), "yyyyMMdd");
    }

    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (StringUtils.isNotBlank(pattern)) {
            formatDate = DateFormatUtils.format(date, pattern);
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

}
