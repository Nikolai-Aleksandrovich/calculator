package com.calculator.secruity;

import com.calculator.domain.UserDetail;

import com.calculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Yuyuan Huang
 * @create 2021-04-29 14:56
 */
@Service
public class ReactiveUserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Bean
    public ReactiveUserDetailsService userDetailsService(){
        return new ReactiveUserDetailsService() {
            @Override
            public Mono<UserDetails> findByUsername(String s) {
                return userRepository.findByUsername(s)
                        .map(user -> {
                            return user.toUserDetail(passwordEncoder);
                        });
            }
        };
    }
}
