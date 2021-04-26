package com.calculator.messageSender;

import com.calculator.domain.Student;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 17:16
 */
@Configuration
public class MassageConfig {
    @Bean
    public MappingJackson2MessageConverter messageConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");
        Map<String,Class<?>> map = new HashMap<>();
        map.put("students", Student.class);
        converter.setTypeIdMappings(map);
        return converter;
    }

    @Bean
    public Destination destination(){
        return new ActiveMQQueue("calculator.scoredetails.queue");
    }
}
