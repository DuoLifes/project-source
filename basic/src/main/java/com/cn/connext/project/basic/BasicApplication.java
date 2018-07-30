package com.cn.connext.project.basic;


import com.cn.connext.project.framework.annotation.ConnextMicroServiceApplication;
import org.springframework.boot.SpringApplication;

@ConnextMicroServiceApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
}
