package com.awei.cloud;

import com.awei.cloud.utils.BaseResponse;
import com.awei.cloud.utils.UUIDUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.UUID;

@SpringBootApplication
@EnableEurekaServer
public class StudentEurekaServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentEurekaServerApplication.class, args);
    }
}
