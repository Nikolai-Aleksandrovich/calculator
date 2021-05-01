package com.calculator.controller;


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
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 16:48
 */
@RestController
@RequestMapping(path = "/student",produces = "application/json")
@CrossOrigin(origins = "*")
public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping(path = "/student/addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Student> postStudent(@RequestBody Mono<Student> studentMono){
        return studentRepository.saveAll(studentMono).next();
    }

    @GetMapping("/allStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Student> findById(@PathVariable String id){
        return studentRepository.findById(id);
    }

    @PatchMapping("allStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Student> editStudent(@PathVariable String id,@RequestBody Mono<Student> studentMono){
        return studentRepository.saveAll(studentMono).next();
    }

    @GetMapping(path = "/allStudent")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Student> allStudent(){
        return studentRepository.findAll();
    }



    @DeleteMapping("/allStudent/deleteStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable String id){
        studentRepository.deleteById(id);
    }


//    @GetMapping(path = "/students/allMyStudent",produces = "application/hal+json")
//    public ResponseEntity<CollectionModel<StudentResource>> allStudent(@AuthenticationPrincipal User user){
//        Flux<Student> list = studentRepository.findAllByCreatedBy(user.getId());
//        CollectionModel<StudentResource> studentResources = new TacoResourceAssembler().toCollectionModel(list);
//        CollectionModel<StudentResource> allStudent = new CollectionModel<StudentResource>(studentResources);
//        allStudent.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).allStudent(user)).withRel("student"));
//        return new ResponseEntity<>(allStudent, HttpStatus.OK);
//    }
}
