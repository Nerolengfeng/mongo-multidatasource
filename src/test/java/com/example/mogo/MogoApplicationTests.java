package com.example.mogo;

import com.example.mogo.entity.primary.PrimaryMongoObject;
import com.example.mogo.repository.primary.PrimaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MogoApplicationTests {

    @Autowired
    private PrimaryRepository primaryRepository;
    
    @Test
    public void contextLoads() {
        PrimaryMongoObject mongoObject = new PrimaryMongoObject();
        mongoObject.setValue("hehe");
        PrimaryMongoObject save = primaryRepository.save(mongoObject);
        System.out.println(save);
        Optional<PrimaryMongoObject> byId = primaryRepository.findById(save.getId());
        System.out.println(byId);

    }

}
