package com.calculator.configuration;

import com.calculator.domain.User;
import com.calculator.secruity.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Yuyuan Huang
 * @create 2021-04-25 2:21
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {
    @Bean
    public AuditorAware<User> auditorProvider(){
        return new SpringSecurityAuditorAware();
    }
}
