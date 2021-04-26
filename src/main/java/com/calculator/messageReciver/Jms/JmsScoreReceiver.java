package com.calculator.messageReciver.Jms;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageReciver.ScoreDetailsReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.Message;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 17:47
 */
@Profile("jms-template")
@Component("scoredetailsReceiver")
public class JmsScoreReceiver implements ScoreDetailsReceiver {

    private JmsTemplate jmsTemplate;
    private MessageConverter messageConverter;

    @Autowired
    public JmsScoreReceiver(JmsTemplate jmsTemplate,MessageConverter messageConverter){
        this.jmsTemplate = jmsTemplate;
        this.messageConverter = messageConverter;
    }


    @Override
    public StudentScoreDetail receiveScoreDetails() {
        return (StudentScoreDetail) jmsTemplate.receiveAndConvert("calculator.scoredetails.queue");
    }
}
