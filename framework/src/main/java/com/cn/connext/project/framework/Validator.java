package com.cn.connext.project.framework;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

public class Validator {
    public static boolean isEmpty(Object object) {
        return StringUtils.isEmpty(object);
    }

    public static boolean isUUID(String string) {
        if (isEmpty(string)) return false;
        if (string.length() != 36) return false;

        try {
            UUID.fromString(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isNotUUID(String string) {
        return !isUUID(string);
    }

    public static boolean isOutLimit(String string, int maxLen) {
        if (isEmpty(string)) return false;
        return string.length() > maxLen;
    }

    public static boolean isNumber(String source){
        try {
            new BigDecimal(source).toString();
        } catch (Exception e) {
            //异常 说明包含非数字。
            return false;
        }
        return true;

    }



}
