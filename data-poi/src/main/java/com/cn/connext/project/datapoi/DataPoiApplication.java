package com.cn.connext.project.datapoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.cn.connext.project.startelasticsearch"})
public class DataPoiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataPoiApplication.class, args);
	}
}
