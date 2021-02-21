//package com.awei.cloud.config;
//
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.ServerAddress;
//import org.springframework.beans.factory.annotation.Autowire;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
//import org.springframework.data.mongodb.core.convert.DbRefResolver;
//import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories(mongoTemplateRef = "mongoTemplate")
//public class MongodbConfig extends AbstractMongoConfiguration{
//
//    @Value("${spring.data.mongodb.host}")
//    String serverAddr;
//    @Value("${spring.data.mongodb.dbname}")
//    String dbName;
//
//    public MongoClient mongoClient() {
//        MongoClient mongoClient = new MongoClient(new ServerAddress(serverAddr));
//        return mongoClient;
//    }
//
//    @Bean(autowire = Autowire.BY_NAME, name = "MongoDbFactory")
//    public MongoDbFactory mongoDbFactory(){
//        return new SimpleMongoDbFactory(mongoClient(),dbName);
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        return dbName;
//    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        return new MongoClient(new ServerAddress(serverAddr));
//    }
//
//    /**
//     * 重写方法去掉_class属性
//     */
//    @Override
//    @Bean(autowire = Autowire.BY_NAME, name = "mongoTemplate")
//    public MongoTemplate mongoTemplate() throws Exception {
//        DbRefResolver dbRefResolver = new DefaultDbRefResolver(this.mongoDbFactory());
//        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext());
//        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//        MongoTemplate mongoTemplate = new MongoTemplate(this.mongoDbFactory(), converter);
////		mongoTemplate.insertAll(objectsToSave);
//        return mongoTemplate;
//    }
//}
