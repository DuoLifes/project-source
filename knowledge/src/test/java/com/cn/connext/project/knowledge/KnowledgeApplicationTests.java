package com.cn.connext.project.knowledge;

import com.cn.connext.project.knowledge.annotation.ForumService;
import com.cn.connext.project.knowledge.annotation.NeedTest;
import com.cn.connext.project.knowledge.enums.Sex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("枚举值:"+Sex.man.getValue());
	}

	@Test
	public void test01(){
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
