package com.calculator.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 2:07
 */
@Data
@Document
@RestResource(rel = "students",path = "students")
public class Student {
    @Id
    private String id;

    @NotNull
    @Size(min = 5,message = "student's name should be more than one word")
    private String name;

}
