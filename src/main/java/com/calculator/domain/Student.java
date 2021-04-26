package com.calculator.domain;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 2:07
 */
@Data
@Entity
@RestResource(rel = "students",path = "students")
public class Student extends Auditable<UUID>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5,message = "student's name should be more than one word")
    private String name;

}
