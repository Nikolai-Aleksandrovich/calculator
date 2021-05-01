package com.calculator.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Yuyuan Huang
 * @create 2021-04-29 15:11
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserDetail implements UserDetails {
    private final String username;
    private final String password;
    private final String fullname;
    private final String city;
    private final String district;
    private final String street;
    private final String phonenumber;
    private final Collection<GrantedAuthority> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    private GrantedAuthority highestRole(Collection<GrantedAuthority> roles){
        GrantedAuthority curRole = null;
        for (GrantedAuthority role :
                roles) {
            //
        }
        return curRole;
    }
    @Override
    public String getUsername(){
        return username;
    }
    @Override
    public String getPassword(){
        return password;
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
