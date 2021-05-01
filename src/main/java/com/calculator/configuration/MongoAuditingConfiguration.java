//package com.calculator.configuration;
//
//import com.calculator.domain.User;
//import com.calculator.secruity.SpringSecurityAuditorAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.mongodb.config.EnableMongoAuditing;
//import org.springframework.security.core.context.SecurityContextHolder;
//
///**
// * @author Yuyuan Huang
// * @create 2021-04-25 2:21
// */
//@Configuration
//@EnableMongoAuditing(auditorAwareRef = "auditorProvider")
//public class MongoAuditingConfiguration {
//    @Bean
//    public AuditorAware<User> auditorProvider(){
//
//        return new SpringSecurityAuditorAware();
//    }
//}
