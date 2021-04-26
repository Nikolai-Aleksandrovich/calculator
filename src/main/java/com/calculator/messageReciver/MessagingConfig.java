package com.calculator.messageReciver;

import com.calculator.domain.StudentScoreDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 18:13
 */
@Profile({"jms","jms-listener"})
@Configuration
public class MessagingConfig {
    @Bean
    public MappingJackson2MessageConverter convertor(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("_typeId");

        Map<String,Class<?>> map = new HashMap<>();
        map.put("scoredetails", StudentScoreDetail.class);
        converter.setTypeIdMappings(map);
        return converter;
    }
}
