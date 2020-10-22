package com.awei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentRoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRoleApplication.class, args);
	}

}
