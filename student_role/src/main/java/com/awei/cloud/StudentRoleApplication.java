package com.awei.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.awei.cloud.dao")
@EnableFeignClients
public class StudentRoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRoleApplication.class, args);
	}

}
