package com.awei.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMongoApplication.class, args);
	}

}
