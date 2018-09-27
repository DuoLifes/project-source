package com.cn.connext.project.demo.domain;

import com.cn.connext.project.demo.entity.Media;
import com.cn.connext.project.framework.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*加深对泛型的理解*/
/*java反射机制虽然可以动态加载传入的实体并输出处理结果，
但是有些情况下必须要在代码里强行把泛型转化为需要的实体，
从而完成业务需求*/
public class InputParam<T> {

    private static final Logger logger = LoggerFactory.getLogger(InputParam.class);
//    public T t;
//
//    public void initOperation(){
//        if(this.t.getClass()== Media.class){
//            /*泛型转化为实体*/
//            Media param = (Media) t;
//            logger.info("param=="+ JSON.toJsonString(param));
//        }
//    }

    public void initOperation(T t){
        if(t.getClass()==Media.class){
            Media param = (Media) t;
           logger.info("param=="+ JSON.toJsonString(param));
        }
    }
}
