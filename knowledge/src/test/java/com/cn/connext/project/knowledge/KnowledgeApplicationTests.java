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
	@Test
	public void contextLoads() {
		System.out.println("枚举值:"+ Sex.man.getValue());
	}
}
