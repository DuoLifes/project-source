package com.cn.connext.project.knowledge;

import com.cn.connext.project.knowledge.enums.Sex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("枚举值:"+Sex.man.getValue());
	}

}
