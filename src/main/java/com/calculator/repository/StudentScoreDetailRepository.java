package com.calculator.repository;

import com.calculator.domain.Student;
import com.calculator.domain.StudentScoreDetail;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 22:38
 */
public interface StudentScoreDetailRepository extends ReactiveMongoRepository<StudentScoreDetail, String> {
    Flux<StudentScoreDetail> findAllByCreatedBy(String id);
}
