package com.example.testSpring.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "index_test")
@Data
public class User {
    @Id
    @NotNull
    private String id;
    @Field(type = FieldType.Text,analyzer="ik_max_word", store = true)
    @NotNull
    private String name;
    @Field(type = FieldType.Text,analyzer="ik_max_word", store = true)
    @NotNull
    private String age;
    @Field(type = FieldType.Text,analyzer="ik_max_word", store = true)
    @NotNull
    private String email;
    @NotNull
    private Date create;
    @NotNull
    private Date update;
}
