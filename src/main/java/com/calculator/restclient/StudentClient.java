package com.calculator.restclient;

import com.calculator.controller.StudentController;
import com.calculator.domain.Student;
import com.calculator.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.EntityMode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 23:22
 */
@Service
@Slf4j
public class StudentClient {
    private RestTemplate restTemplate;
    private Traverson traverson;

    public StudentClient(RestTemplate restTemplate,Traverson traverson){
        this.restTemplate = restTemplate;
        this.traverson = traverson;
    }
    //依照Id得到学生类
    public Student getStudentById(Long id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http//localhost:8080/api/students/{id}")
                .build(map);
        return restTemplate.getForObject(uri,Student.class);
    }
    //得到本账号所有学生类
    public Student[] getStudentByCreatedAt(@AuthenticationPrincipal User user){
        Map<String, UUID> map = new HashMap<>();
        map.put("id",user.getId());
        URI uri = UriComponentsBuilder
                .fromHttpUrl("http//localhost:8080/api/student/{id}")
                .build(map);
        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(uri,Student[].class);
        return responseEntity.getBody();
    }

    //put信息到数据库
    public void updateStudent(Student student){
        restTemplate.put("http://localhost:8080/students/{id}",student,student.getId());

    }

    //POST example
    public Student createStudent(Student student){
        return restTemplate.postForObject("http://localhost:8080/students",student,Student.class);
    }

    //Delete example
    public void deleteStudent(Student student){
        restTemplate.delete("http://localhost:8080/students/{id}",student.getId());
    }


    //Traverson with RestTemplate
    public Iterable<Student> getAllStudentWithTraverson(){
        ParameterizedTypeReference<CollectionModel<Student>> studentType = new ParameterizedTypeReference<CollectionModel<Student>>() {};
        CollectionModel<Student> studentRef = traverson
                .follow("students")
                .toObject(studentType);
        return studentRef.getContent();
    }



    //add with Traverson
    public Student addStudentWithTraverson(Student student){
        String studentUrl = traverson
                .follow("students")
                .asLink()
                .getHref();
        return restTemplate.postForObject(studentUrl,student,Student.class);
    }

}
