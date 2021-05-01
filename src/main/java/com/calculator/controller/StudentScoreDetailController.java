package com.calculator.controller;

import com.calculator.domain.Student;
import com.calculator.domain.StudentScoreDetail;
import com.calculator.domain.User;
import com.calculator.repository.StudentScoreDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 22:37
 */
@RestController
@RequestMapping(path = "/details",produces = "application/json")
@CrossOrigin(origins = "*")
//将spring data rest的基本路径作为自己的路径
public class StudentScoreDetailController {
    private StudentScoreDetailRepository studentScoreDetailRepository;

    @Autowired
    public StudentScoreDetailController(StudentScoreDetailRepository studentScoreDetailRepository){
        this.studentScoreDetailRepository = studentScoreDetailRepository;
    }

    @PostMapping(path = "/student/addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<StudentScoreDetail> postStudent(@RequestBody Mono<StudentScoreDetail> studentDetailsMono){
        return studentScoreDetailRepository.saveAll(studentDetailsMono).next();
    }

    @GetMapping("/allStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<StudentScoreDetail> findById(@PathVariable String id){
        return studentScoreDetailRepository.findById(id);
    }

    @PatchMapping("allStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<StudentScoreDetail> editStudent(@PathVariable String id,@RequestBody Mono<StudentScoreDetail> studentDetailsMono){
        return studentScoreDetailRepository.saveAll(studentDetailsMono).next();
    }

    @GetMapping(path = "/allStudent")
    @ResponseStatus(HttpStatus.OK)
    public Flux<StudentScoreDetail> allStudent(){
        return studentScoreDetailRepository.findAll();
    }



    @DeleteMapping("/allStudent/deleteStudent/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable String id){
        studentScoreDetailRepository.deleteById(id);
    }

//    @GetMapping(path = "/score",produces = "application/hal+json")
//    public Res
}
