package com.calculator.secruity;

import com.calculator.domain.User;
import com.calculator.domain.UserDetail;
import com.calculator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 1:45
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
//    @Autowired
//    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        return http
                .authorizeExchange()
                .pathMatchers("/student","/student/studentScoreDetails","/student/score")
                .hasAuthority("USER")
                .anyExchange()
                .permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                .and()
                    .logout()
                    .logoutUrl("/homePage")
                .and()
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers(HttpMethod.POST,"/")
////                .antMatchers(HttpMethod.POST, "/api/ingredients").permitAll()
////                .antMatchers("/design", "/orders/**")
////                .permitAll()
////                //.access("hasRole('ROLE_USER')")
////                .antMatchers(HttpMethod.PATCH, "/ingredients").permitAll()
////                .antMatchers("/**").access("permitAll")
////
////                .and()
////                .formLogin()
////                .loginPage("/login")
////
////                .and()
////                .httpBasic()
////                .realmName("Taco Cloud")
////
////                .and()
////                .logout()
////                .logoutSuccessUrl("/")
////
////                .and()
////                .csrf()
////                .ignoringAntMatchers("/h2-console/**", "/ingredients/**", "/design", "/orders/**", "/api/**")
////
////                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
////                .and()
////                .headers()
////                .frameOp
////                tions()
////                .sameOrigin()
//        ;
//
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }

}
