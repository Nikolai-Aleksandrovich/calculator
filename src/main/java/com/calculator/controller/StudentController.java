package com.calculator.controller;

import com.calculator.api.StudentResource;
import com.calculator.api.TacoResourceAssembler;
import com.calculator.domain.Student;
import com.calculator.domain.User;
import com.calculator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 16:48
 */
@RepositoryRestController
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping(path = "/students/allMyStudent",produces = "application/hal+json")
    public ResponseEntity<CollectionModel<StudentResource>> allStudent(@AuthenticationPrincipal User user){
        List<Student> list = studentRepository.findAllByCreatedBy(user.getId());
        CollectionModel<StudentResource> studentResources = new TacoResourceAssembler().toCollectionModel(list);
        CollectionModel<StudentResource> allStudent = new CollectionModel<StudentResource>(studentResources);
        allStudent.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).allStudent(user)).withRel("student"));
        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }
}
