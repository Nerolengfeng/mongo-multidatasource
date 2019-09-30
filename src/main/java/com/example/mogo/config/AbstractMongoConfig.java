package com.example.mogo.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @program: mongo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-30 09:20
 **/
@Data
public abstract class AbstractMongoConfig {
    // 变量名跟配置的参数对应
    private String uri;

    @Autowired
    MongoSettingsProperties properties;

    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
        builder.connectionsPerHost(properties.getMaxConnectionsPerHost());
        builder.minConnectionsPerHost(properties.getMinConnectionsPerHost());
        builder.threadsAllowedToBlockForConnectionMultiplier(
            properties.getThreadsAllowedToBlockForConnectionMultiplier());
        builder.serverSelectionTimeout(properties.getServerSelectionTimeout());
        builder.maxWaitTime(properties.getMaxWaitTime());
        builder.maxConnectionIdleTime(properties.getMaxConnectionIdleTime());
        builder.maxConnectionLifeTime(properties.getMaxConnectionLifeTime());
        builder.connectTimeout(properties.getConnectTimeout());
        builder.socketTimeout(properties.getSocketTimeout());
        // builder.socketKeepAlive(properties.getSocketKeepAlive());
        builder.sslEnabled(properties.getSslEnabled());
        builder.sslInvalidHostNameAllowed(properties.getSslInvalidHostNameAllowed());
        builder.alwaysUseMBeans(properties.getAlwaysUseMBeans());
        builder.heartbeatFrequency(properties.getHeartbeatFrequency());
        builder.minHeartbeatFrequency(properties.getMinHeartbeatFrequency());
        builder.heartbeatConnectTimeout(properties.getHeartbeatConnectTimeout());
        builder.heartbeatSocketTimeout(properties.getHeartbeatSocketTimeout());
        builder.localThreshold(properties.getLocalThreshold());



        // 连接认证
        // MongoCredential mongoCredential = null;
        // 	mongoCredential = MongoCredential.createScramSha1Credential(MongoCredential.createCredential(username, database, password.toCharArray()));
        // 创建认证客户端
        // MongoClient mongoClient = new MongoClient(serverAddresses, mongoCredential, mongoClientOptions);

        // 创建非认证客户端
        MongoClientURI mongoClientURI = new MongoClientURI(getUri(), builder);

        // 创建MongoDbFactory
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClientURI);
        return mongoDbFactory;

        // 有认证的初始化方法
        // ServerAddress serverAddress = new ServerAddress(host, port);
        // List<MongoCredential> mongoCredentialList = new ArrayList<>();
        // mongoCredentialList.add(MongoCredential.createCredential(username, database,
        // password.toCharArray()));
        // return new SimpleMongoDbFactory(new MongoClient(serverAddress,
        // mongoCredentialList), database);
    }


    /*
     * Factory method to create the MongoTemplate
     */
    abstract public MongoTemplate getMongoTemplate() throws Exception;


}
