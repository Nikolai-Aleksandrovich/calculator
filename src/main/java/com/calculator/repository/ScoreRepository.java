package com.calculator.repository;

import com.calculator.domain.Score;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 23:23
 */
public interface ScoreRepository extends CrudRepository<Score,Long> {
}
