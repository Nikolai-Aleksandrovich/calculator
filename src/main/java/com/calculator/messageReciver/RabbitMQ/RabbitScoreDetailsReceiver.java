package com.calculator.messageReciver.RabbitMQ;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageReciver.ScoreDetailsReceiver;
import org.hibernate.annotations.FetchProfile;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 19:45
 */
@Profile("rabbitmq-receiver")
@Component
public class RabbitScoreDetailsReceiver implements ScoreDetailsReceiver {
    private RabbitTemplate rabbitTemplate;
    private MessageConverter messageConverter;

    @Autowired
    public RabbitScoreDetailsReceiver(MessageConverter messageConverter,RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        this.messageConverter = messageConverter;
    }
    @Override
    public StudentScoreDetail receiveScoreDetails() {
        return rabbitTemplate.receiveAndConvert("calculator.scoredetails.queue", new ParameterizedTypeReference<StudentScoreDetail>() {});
    }


}
