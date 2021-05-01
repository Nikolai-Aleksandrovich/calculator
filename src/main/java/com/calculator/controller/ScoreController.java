package com.calculator.controller;

import com.calculator.domain.Score;
import com.calculator.domain.Student;
import com.calculator.domain.User;
import com.calculator.repository.ScoreRepository;
import com.calculator.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Yuyuan Huang
 * @create 2021-04-29 22:16
 */

@RestController
@RequestMapping(path = "/score",produces = "application/json")
@CrossOrigin(origins = "*")
public class ScoreController {
    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreController( ScoreRepository scoreRepository){
        this.scoreRepository = scoreRepository;
    }


    @PostMapping(path = "/score/addStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Score> postStudent(@RequestBody Mono<Score> scoreMono){
        return scoreRepository.saveAll(scoreMono).next();
    }

    @GetMapping("/allScore/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Score> findById(@PathVariable String id){
        return scoreRepository.findById(id);
    }

    @PatchMapping("allScore/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Score> editScore(@PathVariable String id,@RequestBody Mono<Score> scoreMono){
        return scoreRepository.saveAll(scoreMono).next();
    }

    @GetMapping(path = "/allScore")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Score> allScore(){
        return scoreRepository.findAll();
    }



    @DeleteMapping("/allScore/deleteScore/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteScore(@PathVariable String id){
        scoreRepository.deleteById(id);
    }
}
