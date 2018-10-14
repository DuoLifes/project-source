package com.cn.connext.project.devops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class DevopsApplication {
	public static void main(String[] args) {
		SpringApplication.run(DevopsApplication.class, args);
	}
}
