package com.example.mogo.config;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @program: mongo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-29 16:20
 **/
@Data
@Configuration
//读取配置文件中spring.data.mongodb.testdb 开头的属性如database，通过反射调用setDatabase()保存从配置文件中读取的database值
//需要maven依赖 spring-boot-configuration-processor
@ConfigurationProperties(prefix = "spring.data.mongodb.testdb")
public class TestdbMongoConfiguration extends AbstractMongoConfig{

    //第一个数据库 默认作为主数据库 需要添加注解 @Primary ，后面的数据库不需要这个注解
    @Primary
    @Bean(name = "mongoTemplate")
    @Override
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
