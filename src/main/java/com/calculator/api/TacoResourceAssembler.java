package com.calculator.api;

import com.calculator.controller.StudentController;
import com.calculator.domain.Student;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;



/**
 * @author Yuyuan Huang
 * @create 2021-04-25 18:06
 */
public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Student,StudentResource>{
    //告诉超类在创建链接的过程中，默认使用这个Controller
    public TacoResourceAssembler() {
        super(StudentController.class, StudentResource.class);
    }
    //基于给定的student实例化Resource
    @Override
    protected StudentResource instantiateModel(Student student){
        return new StudentResource(student);
    }

    //通过Student创建Resource(with id)，并设置一个id链接
    @Override
    public StudentResource toModel(Student entity) {
        return createModelWithId(entity.getId(),entity);
    }
}
