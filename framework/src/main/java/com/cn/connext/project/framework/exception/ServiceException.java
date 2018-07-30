package com.cn.connext.project.framework.exception;

import com.cn.connext.project.framework.globalzation.GlobalResource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zhangshuai on 2017/12/11.
 */
public class ServiceException extends RuntimeException {

    private String code;
    private String message;

    public ServiceException(String code) {
        Locale chinaLocale = new Locale("zh", "CN");
        ResourceBundle chinaResource = ResourceBundle.getBundle("message", chinaLocale);

        this.code = code;
        this.message = GlobalResource.getLocaleMessage(code);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
