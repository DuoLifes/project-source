package com.cn.connext.project.datapoi;

import com.cn.connext.project.framework.annotation.ConnextMicroServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@ConnextMicroServiceApplication(scanBasePackages = {"com.cn.connext.project.startelasticsearch"})
public class DataPoiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataPoiApplication.class, args);
	}
}
