package com.cn.connext.project.demo.webapi;

import com.cn.connext.project.demo.domain.InputParam;
import com.cn.connext.project.demo.entity.Media;
import com.cn.connext.project.demo.entity.Partner;
import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.framework.annotation.WebAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.async.DeferredResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 案例测试接口 - WebAPI访问接口
 * 开发人员: 张帅
 * 修订日期: 2018-01-25 15:18:53
 */
@WebAPI("/api/demo/example01")
public class Example01API {

    private static final Logger logger = LoggerFactory.getLogger(Example01API.class);

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


    /*泛型对实体的转化*/
    @GetMapping("/02")
    public void test02(){
        Media media=new Media();
        InputParam inputParam=new InputParam();
        /*泛型传参两种方式*/
        /*1.把泛型定义为一个字段或属性来传递*/
//        inputParam.t=media;
//        inputParam.initOperation();
        /*2.定义方法，把实体当参数传给泛型*/
        inputParam.initOperation(media);
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

    /*EntityManager接口的增删改查方法测试*/
    //两种注入方式其一:
    @PersistenceContext(unitName = "mysqlEntityManagerFactory")
    private EntityManager entityManager;
    @GetMapping("/04")
    @Transactional("mysqlTransactionManager")
    public void test04(){
        Media media=new Media();
        entityManager.merge(media);
        entityManager.flush();
    }


    //两种注入方式其二:
    @Autowired
    @Qualifier("mysqlEntityManagerFactory")
    private EntityManager em;
    @GetMapping("/05")
    public void test05(){
        Media media=new Media();
        em.merge(media);
        em.flush();
    }


    /*存储过程的实现*/
    @Autowired
    @Qualifier("mysqlEntityManagerFactory")
    private EntityManager em1;
    @GetMapping("/06")
    public void test06(){
        StoredProcedureQuery storedProcedureQuery = em1.createNamedStoredProcedureQuery("getPartnerList");
        storedProcedureQuery.execute();
        List<Partner> list=storedProcedureQuery.getResultList();
        list.forEach(partner -> {
            logger.info(JSON.toJsonString(partner));
        });
    }

    /*EntityManager接口自定义构建查询语句*/
    @Autowired
    @Qualifier("mysqlEntityManagerFactory")
    private EntityManager em2;
    @GetMapping("/07")
    public List<Partner> test07(){
        String name="易车网";
        //原生SQL查询
        List<Partner> list = em2.createNativeQuery("select * from partner where name like :name", Partner.class)
                //em2.createNativeQuery("select * from partner where name like :name", "PartnerMapping") //用此方法需要在实体类定义映射
                .setParameter("name", name)
                .setMaxResults(5)
                .getResultList();
       return list;
    }

    /*SpringMVC异步实现*/
    @GetMapping("/08")
    public DeferredResult<String> deferredResult(){
        DeferredResult<String> deferredResult = new DeferredResult<String>(10000L);
        new Thread() {
            @Override
            public void run() {
                try {
                    String result="测试";
                    deferredResult.setResult(result);
                    Thread.sleep(3000);
                } catch (Exception e) {
                    deferredResult.setErrorResult(e);
                }
            }
        }.start();
        return deferredResult;
    }

    /*SpringMVC同步请求*/
    @GetMapping("/09")
    public String synchronization(){
        try {
            Thread.sleep(5000);
            return "结束";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "完结";
    }
}

