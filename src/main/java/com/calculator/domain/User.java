package com.calculator.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * @author Yuyuan Huang
 * @create 2021-04-24 23:50
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true,access = AccessLevel.PRIVATE)
@Document
public class User implements UserDetails {
    @Id
    private String id;

    private final String username;
    private final String password;
    private final String fullname;
    private final String city;
    private final String district;
    private final String street;
    private final String phonenumber;
    private final Collection<GrantedAuthority> role;


    public UserDetail toUserDetail(PasswordEncoder passwordEncoder){
        return new UserDetail(username, passwordEncoder.encode(password), fullname, city, district, street, phonenumber,role);

    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
