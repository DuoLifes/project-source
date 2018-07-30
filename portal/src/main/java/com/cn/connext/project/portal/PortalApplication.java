package com.cn.connext.project.portal;

import com.cn.connext.project.framework.annotation.ConnextMicroServiceApplication;
import org.springframework.boot.SpringApplication;


@ConnextMicroServiceApplication
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}
}
