package com.calculator.messageSender.Jms;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageSender.ScoreMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 15:33
 */
@Service
public class JmsOrderMessagingService implements ScoreMessageService {

    private JmsTemplate jmsTemplate;
    private MappingJackson2MessageConverter messageConverter;
    private Destination destination;

    @Autowired
    public JmsOrderMessagingService(Destination destination,JmsTemplate jmsTemplate, MappingJackson2MessageConverter messageConverter) {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
        this.messageConverter = messageConverter;
    }


    @Override
    public void sendScoreDetail(StudentScoreDetail studentScoreDetail) {
        jmsTemplate.convertAndSend(destination,studentScoreDetail,this::addScoreSource);
    }

    private Message addScoreSource(Message message)throws JMSException{
        message.setStringProperty("X_STUDENT_TYPE","LOCAL");
        return message;
    }



}
