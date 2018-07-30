package com.cn.connext.project.framework.exception;

import com.cn.connext.project.framework.JSON;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> serviceExceptionHandler(ServiceException e) throws Exception {
        Map<String, String> map = new HashMap<>(2);
        map.put("code", e.getCode());
        map.put("message", e.getMessage());

        String exceptionType = e.getClass().getName();
        HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;
        switch (exceptionType) {
            case "com.cn.connext.project.framework.exception.ServiceBadRequestException":
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
        }
        return new ResponseEntity<>(map, httpStatus);
    }


    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> defaultErrorHandler(HttpServletRequest request, HttpServletResponse response, Throwable e) throws Exception {
        Map<String, String> map = new HashMap<>(2);
        map.put("code", "SYSTEM");
        map.put("message", e.getMessage());


        String exceptionType = e.getClass().getName();
        HttpStatus httpStatus;
        switch (exceptionType) {
            case "org.springframework.http.converter.HttpMessageNotReadableException":
                httpStatus = HttpStatus.BAD_REQUEST;
                map.put("code", "SYSTEM");
                map.put("message", "Body should be a JSON object");
                break;

            case "org.springframework.web.HttpRequestMethodNotSupportedException":
                httpStatus = HttpStatus.BAD_REQUEST;
                map.put("code", "SYSTEM");
                map.put("message", "Request method " + request.getMethod().toLowerCase() + " not supported for this url.");
                break;

            case "org.springframework.web.HttpMediaTypeNotSupportedException":
                httpStatus = HttpStatus.BAD_REQUEST;
                map.put("code", "SYSTEM");
                map.put("message", "Request method " + request.getContentType() + " not supported for this url.");
                break;

            case "org.apache.catalina.connector.ClientAbortException":
                httpStatus = HttpStatus.BAD_REQUEST;
                map.put("code", "SYSTEM");
                map.put("message", "Connection reset by peer.");
                break;

            default:
                httpStatus = HttpStatus.EXPECTATION_FAILED;
                map.put("code", "SYSTEM");
                map.put("message", "Server busy.");
                logger.error(e.getMessage(), e);
                break;
        }
        return new ResponseEntity<>(map, httpStatus);
    }

    /**
     * 负载均衡层面
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = FeignException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> serviceExceptionHandler(FeignException e) throws Exception {
        Map<String, String> map = new HashMap<>(2);
        String message = e.getMessage();
        int i = message.indexOf("content:");
        if (i == -1) {
            map.put("code", String.valueOf(e.status()));
            map.put("message", e.getMessage());
        } else {
            String m = message.substring(i + 8).trim();
            Message mes = JSON.parseObject(m, Message.class);
            map.put("code", mes.code);
            map.put("message", mes.message);
        }
        logger.error(e.getMessage(), e);
        HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;
        return new ResponseEntity<>(map, httpStatus);
    }

    /**
     * 数据库访问层面
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = DataAccessException.class)
    @ResponseBody
    public ResponseEntity<Map<String, String>> serviceExceptionHandler(DataAccessException e) throws Exception {
        Map<String, String> map = new HashMap<>(2);
        map.put("code", "DATA ACCESS");
        map.put("message", "数据库访问错误");

        logger.error(e.getMessage(), e);
        HttpStatus httpStatus = HttpStatus.EXPECTATION_FAILED;
        return new ResponseEntity<>(map, httpStatus);
    }

}
