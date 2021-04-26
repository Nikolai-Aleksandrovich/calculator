package com.calculator.repository;

import com.calculator.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 16:47
 */
public interface StudentRepository extends CrudRepository<Student,Long> {
    List<Student> findAllByCreatedBy(UUID uuid);

}
