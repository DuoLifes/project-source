package com.cn.connext.project.multidatasource;


import com.cn.connext.project.framework.annotation.ConnextMicroServiceApplication;
import org.springframework.boot.SpringApplication;

@ConnextMicroServiceApplication
public class MultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceApplication.class, args);
	}
}
