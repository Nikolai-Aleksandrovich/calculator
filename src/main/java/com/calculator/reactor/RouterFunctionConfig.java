package com.calculator.reactor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;


import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static reactor.core.publisher.Mono.just;

/**
 * @author Yuyuan Huang
 * @create 2021-04-27 2:45
 */
@Configuration
public class RouterFunctionConfig {
    @Bean
    public RouterFunction<?> helloRouterFunction(){
        return route(GET("/api/students"),request -> ok().body(just("Hello World"),String.class))
    }

}
