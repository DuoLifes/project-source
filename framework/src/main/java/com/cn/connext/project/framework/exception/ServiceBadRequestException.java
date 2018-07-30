package com.cn.connext.project.framework.exception;

public class ServiceBadRequestException extends ServiceException {

    public ServiceBadRequestException(String code) {
        super(code);
    }

    public ServiceBadRequestException(String code, String message) {
        super(code, message);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
