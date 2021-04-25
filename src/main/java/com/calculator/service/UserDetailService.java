package com.calculator.service;

import com.calculator.domain.User;
import com.calculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 0:40
 */
public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public UserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(s);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }
            throw new UsernameNotFoundException("User "+s+" is not in system");


    }
}
