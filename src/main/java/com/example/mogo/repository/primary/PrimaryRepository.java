package com.example.mogo.repository.primary;

import com.example.mogo.entity.primary.PrimaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: mogo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-27 11:04
 **/
//@Repository
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {


}
