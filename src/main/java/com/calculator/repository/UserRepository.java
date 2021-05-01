package com.calculator.repository;

import com.calculator.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 0:29
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {
    Mono<User> findByUsername(String name);

}
