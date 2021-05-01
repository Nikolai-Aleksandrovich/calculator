package com.calculator.controller;

import com.calculator.domain.User;
import com.calculator.domain.UserRegistrationForm;
import com.calculator.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 0:49
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("register")
    public String registerForm(){
        return "registration";
    }

    @PostMapping("registration")
    public String register(UserRegistrationForm userRegistrationForm){
        userRepository.save(userRegistrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }
    @GetMapping("/{username}")
    public Mono<User> get(@PathVariable() String username){
        return userRepository.findByUsername(username);
    }

}
