package com.example.mogo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @program: mongo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-29 16:21
 **/
@Data
@Configuration
//读取配置文件中spring.data.mongodb.testdb 开头的属性如database，通过反射调用setDatabase()保存从配置文件中读取的database值
//需要maven依赖 spring-boot-configuration-processor
@ConfigurationProperties(prefix = "spring.data.mongodb.testdb2")
public class Testdb2MongoConfiguration extends AbstractMongoConfig{

    @Autowired
    MongoSettingsProperties properties;

    //这是第二个数据库源，不需要注解 @Primary
    @Bean(name = "testdb2MongoTemplate")
    @Override
    public MongoTemplate getMongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }

}
