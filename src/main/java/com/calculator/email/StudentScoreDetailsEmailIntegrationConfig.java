package com.calculator.email;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.repository.StudentScoreDetailRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.support.GenericMessage;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 23:06
 */
@Configuration
public class StudentScoreDetailsEmailIntegrationConfig {
    @Bean
    @InboundChannelAdapter(poller = @Poller(fixedRate = "1000"),channel = "scoredetailsChannel")
    public MessageSource<StudentScoreDetail> scoreDetailMessageSource(StudentScoreDetail studentScoreDetail){
        return () -> {
            return new GenericMessage<>(studentScoreDetail);
        };
    }
    @Bean
    @ServiceActivator(inputChannel = "scoredetailsChannel",outputChannel = "calculateScoreChannel")
    public GenericHandler<Long> scoreHandler(StudentScoreDetailRepository studentScoreDetailRepository){
        Long score =
        return (payload,headers) -> {return studentScoreDetailRepository.save(payload);};

    }

}
