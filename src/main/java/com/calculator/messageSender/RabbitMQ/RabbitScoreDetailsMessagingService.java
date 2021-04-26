package com.calculator.messageSender.RabbitMQ;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageSender.ScoreMessageService;
import org.ietf.jgss.MessageProp;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 18:32
 */
@Service
public class RabbitScoreDetailsMessagingService implements ScoreMessageService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitScoreDetailsMessagingService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

//    @Override
//    public void sendScoreDetail(StudentScoreDetail studentScoreDetail) {
//        MessageConverter converter = rabbitTemplate.getMessageConverter();
//        MessageProperties messageProperties = new MessageProperties();
//        messageProperties.setHeader("STUDENT_TYPE","LOCAL");
//        Message message = converter.toMessage(studentScoreDetail,messageProperties);
//        rabbitTemplate.send("calculate.scoredetail",message);
//    }
    @Override
    public void sendScoreDetail(StudentScoreDetail studentScoreDetail){
        rabbitTemplate.convertAndSend("calculate.scoredetail", studentScoreDetail, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = new MessageProperties();
                messageProperties.setHeader("STUDENT_TYPE","LOCAL");
                return message;
            }
        });

    }
}
