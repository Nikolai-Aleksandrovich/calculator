package com.calculator.repository;

import com.calculator.domain.Score;
import com.calculator.domain.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 23:23
 */

public interface ScoreRepository extends ReactiveCrudRepository<Score,String> {
    Flux<Score> findAllByCreatedBy(String id);
}
