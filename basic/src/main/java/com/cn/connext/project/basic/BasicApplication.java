package com.cn.connext.project.basic;


import com.cn.connext.project.framework.annotation.ConnextMicroServiceApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ConnextMicroServiceApplication
//@MapperScan("com.cn.connext.project.basic.repository")
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
}
