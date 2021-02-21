package com.awei.cloud;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableMongoRepositories
public class StudentMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMongoApplication.class, args);
    }

//    @Bean
//    public MongoClient mongo() throws Exception {
//        return new MongoClient("localhost", 27017);
//    }
//
//    //注入mongoTemplate
//    @Bean
//    public MongoTemplate getMongoTemplate() throws Exception {
//        return new MongoTemplate(mongo(), "sutianwei");
//    }

}
