package com.example.mogo.entity.primary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @program: mogo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-27 11:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "testd")
public class PrimaryMongoObject {

    @Id
    private String id;

    @Field(value = "a0")
    private String value;

    @Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
            + '}';
    }
}
