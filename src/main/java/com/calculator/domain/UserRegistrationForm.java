package com.calculator.domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 0:28
 */
@Data
public class UserRegistrationForm {
    private String username;
    private String password;
    private String fullname;
    private String city;
    private String district;
    private String street;
    private String phonenumber;
    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,passwordEncoder.encode(password),fullname,city,district,street,phonenumber);
    }
}
