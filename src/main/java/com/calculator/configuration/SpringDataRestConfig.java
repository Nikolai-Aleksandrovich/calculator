package com.calculator.configuration;

import com.calculator.domain.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.RepresentationModelProcessor;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 22:48
 */
@Configuration
public class SpringDataRestConfig {
    @Bean
    public RepresentationModelProcessor<CollectionModel<EntityModel<Student>>> studentProcessor(EntityLinks links){
        return new RepresentationModelProcessor<CollectionModel<EntityModel<Student>>>() {
            @Override
            public CollectionModel<EntityModel<Student>> process(CollectionModel<EntityModel<Student>> model) {
                model.add(links.linkFor(Student.class)
                .slash("studentManage")
                .withRel("student"));
                return model;
            }
        };
    }
}
