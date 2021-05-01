package com.calculator.repository;

import com.calculator.domain.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 16:47
 */
public interface StudentRepository extends ReactiveMongoRepository<Student,String> {
    Flux<Student> findAllByCreatedBy(String id);



}
