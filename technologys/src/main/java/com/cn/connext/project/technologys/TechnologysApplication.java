package com.cn.connext.project.technologys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*此注解为特定字段添加创建修改时间和执行人*/
@EnableJpaAuditing
public class TechnologysApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologysApplication.class, args);
	}
}
