package com.example.mogo.entity.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: mogo
 * @description:
 * @author: 段闪闪 duanss
 * @create: 2019-09-27 11:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Aladin_WayBill")
public class SecondMongoObject {

    @Id
    private String id;

    private String value;

    @Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + value + '\''
            + '}';
    }
}
