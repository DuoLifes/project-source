package com.cn.connext.project.framework.globalzation;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalResource {
    public static String getLocaleMessage(String code) {
        Locale chinaLocale = new Locale("zh", "CN");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", chinaLocale);

        if (resourceBundle.containsKey(code)) {
            try {
                String sourceString = resourceBundle.getString(code);
                return new String(sourceString.getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception e) {
                return "";
            }
        } else {
            resourceBundle = ResourceBundle.getBundle("global", chinaLocale);
            try {
                String sourceString = resourceBundle.getString(code);
                return new String(sourceString.getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception e) {
                return code;
            }
        }
    }
}
