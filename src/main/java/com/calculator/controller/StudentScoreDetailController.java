package com.calculator.controller;

import com.calculator.repository.StudentScoreDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 22:37
 */
@RepositoryRestController
//将spring data rest的基本路径作为自己的路径
public class StudentScoreDetailController {
    private StudentScoreDetailRepository studentScoreDetailRepository;

    @Autowired
    public StudentScoreDetailController(StudentScoreDetailRepository studentScoreDetailRepository){
        this.studentScoreDetailRepository = studentScoreDetailRepository;
    }

//    @GetMapping(path = "/score",produces = "application/hal+json")
//    public Res
}
