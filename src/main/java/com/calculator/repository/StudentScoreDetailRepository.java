package com.calculator.repository;

import com.calculator.domain.StudentScoreDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 22:38
 */
public interface StudentScoreDetailRepository extends CrudRepository<StudentScoreDetail,Long> {
}
