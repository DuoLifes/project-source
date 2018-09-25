package com.cn.connext.project.knowledge.webapi;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import com.cn.connext.project.knowledge.entity.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebAPI("/api/knoledge/demo")
public class DemoAPI {

    private static final Logger logger = LoggerFactory.getLogger(DemoAPI.class);

    //psvm快捷创建main方法
    public static void main(String[] args) {
        Media media=new Media();
        logger.info("media:"+ JSON.toJsonString(media));
    }
}
