package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.demo.domain.InputParam;
import com.cn.connext.project.demo.entity.Media;
import com.cn.connext.project.framework.Validator;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.Method;

/**
 * 案例测试接口 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/demo/test")
public class DemoAPI {

    private static final Logger logger = LoggerFactory.getLogger(DemoAPI.class);

    /*验证java反射机制*/
    @GetMapping("/01")
    public void test01(){
        try {
            Media media = new Media();
            Method method = media.getClass().getMethod("getId", null);
            Object value = method.invoke(media,null);
            if(value != null) {
                String value1 = value.toString();
                logger.info("value1=="+value1);
            }
        }catch (Exception e){
            logger.info("e:"+e);
        }
    }
    /*验证字段是否为空*/
    @GetMapping("/02")
    public void test02(){
        String value="abcdefg";
        boolean flag=Validator.isEmpty(value);
        logger.info("flag=="+flag);
    }

    /*泛型对实体的转化*/
    @GetMapping("/03")
    public void test03(){
        Media media=new Media();
        InputParam inputParam=new InputParam();
        /*泛型传参两种方式*/
        /*1.把泛型定义为一个字段或属性来传递*/
//        inputParam.t=media;
//        inputParam.initOperation();
        /*2.定义方法，把实体当参数传给泛型*/
        inputParam.initOperation(media);
    }

    /*EntityManager接口的增删改查方法测试*/
    @PersistenceContext(unitName = "mysqlEntityManagerFactory")
    private EntityManager entityManager;
    @GetMapping("/04")
    @Transactional("mysqlTransactionManager")
    public void test3(){
        Media media=new Media();
        entityManager.merge(media);
        entityManager.flush();
    }
    /*
    persist() :添加实体Bean
    flush() ：将实体的改变立刻刷新到数据库中
    merge () :比较麻烦，用好了很不错，配合flush
    Remove() :删除对象
    createQuery() ：返回Query对象,以执行JPQL语句
    createNativeQuery() ：返回Query对象,以执行SQL语句
    refresh() ：刷新实体Bean,以得到对新对象
    contains()： 检测实体当前是否被管理中
    clear() 分离所有当前正在被管理的实体
*/

    @Autowired
    @Qualifier("mysqlEntityManagerFactory")
    private EntityManager em;

}

