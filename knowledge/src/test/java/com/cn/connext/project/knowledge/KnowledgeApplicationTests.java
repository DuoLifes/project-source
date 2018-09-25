package com.cn.connext.project.knowledge;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.knowledge.annotation.ForumService;
import com.cn.connext.project.knowledge.annotation.NeedTest;
import com.cn.connext.project.knowledge.entity.Media;
import com.cn.connext.project.knowledge.enums.Sex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(KnowledgeApplicationTests.class);

	@Test
	public void contextLoads() {
		System.out.println("枚举值:"+ Sex.man.getValue());
	}

	/*截取字符串*/
	@Test
	public void test01() {
		String str="This,Server,Is,Knowledge!";
		String[] test = str.split(",");
		for (int i=0;i<test.length;i++) {
			System.out.println("第"+(i+1)+"个元素是:"+test[i]);
		}
	}
	/*打印map*/
	@Test
	public void test02() {
		Map<String,Object> map=new HashMap<>();
		map.put("name","张三");
		map.put("time",new Date());
		map.put("age",25);
		logger.info("map:"+map.toString());
		//System.exit(0);
	}
	/*重写toString方法打印实体*/
	@Test
	public void test03() {
		Media media=new Media();
		logger.info("media:"+ JSON.toJsonString(media));
		logger.info("media:"+ media.toString());
	}

	/*自定义注解验证*/
	@Test
	public void test04(){
		//获取类
		Class clazz= ForumService.class;
		//获取类中的方法
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods){
			//获取方法上的注解
			NeedTest nt=method.getAnnotation(NeedTest.class);
			if(nt!=null){
				if(nt.value()){
					System.out.println("需要测试");
				}
				else {
					System.out.println("不需要测试");
				}
			}
		}
	}
}
