package com.cn.connext.project.technologys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TechnologysApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechnologysApplication.class, args);
	}
}
