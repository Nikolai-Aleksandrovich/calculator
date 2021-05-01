package com.calculator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yuyuan Huang
 * @create 2021-04-29 12:06
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry controllerRegistry){
        controllerRegistry.addViewController("/").setViewName("home");
        controllerRegistry.addViewController("/login").setViewName("login");
    }

}
