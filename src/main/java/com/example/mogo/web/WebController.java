package com.example.mogo.web;

import com.example.mogo.entity.primary.PrimaryMongoObject;
import com.example.mogo.entity.second.SecondMongoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mongo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-29 16:26
 **/
@RestController
public class WebController {
    @Autowired
    @Qualifier(value = "mongoTemplate")
    protected MongoTemplate testdbMongoTemplate;

    @Autowired
    @Qualifier(value = "testdb2MongoTemplate")
    protected MongoTemplate testdb2MongoTemplate;

    @RequestMapping("/test")
    public String test(){
        //第一个数据库源testdb
        Query query = new Query();
        query.addCriteria(Criteria.where("a0").is("ZJS001001439213"));
        PrimaryMongoObject user = testdbMongoTemplate.findOne(query, PrimaryMongoObject.class);

        //第二个数据库源testdb2
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("ydh").is("A602966298200"));
        SecondMongoObject music = testdb2MongoTemplate.findOne(query2, SecondMongoObject.class);
        return "来自第一个数据库源 " + user.toString() + "<br/>来自第二个数据库源 " +music.toString();
    }
}
