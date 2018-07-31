package com.cn.connext.project.multidatasource;

import com.cn.connext.project.framework.mongodbrepository.ConnextMongoRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.cn.connext.project.multidatasource","com.cn.connext.project.startelasticsearch"})
@EnableMongoRepositories(repositoryBaseClass = ConnextMongoRepositoryImpl.class)
public class MultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiDatasourceApplication.class, args);
	}
}
