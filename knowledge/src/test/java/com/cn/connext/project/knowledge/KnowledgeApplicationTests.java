package com.cn.connext.project.knowledge;

import com.cn.connext.project.framework.JSON;
import com.cn.connext.project.knowledge.entity.Media;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(KnowledgeApplicationTests.class);

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
}
