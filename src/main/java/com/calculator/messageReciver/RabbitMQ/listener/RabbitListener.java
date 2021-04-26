package com.calculator.messageReciver.RabbitMQ.listener;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageReciver.ReceiverUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 20:02
 */
@Component
public class RabbitListener {
    private ReceiverUI receiverUI;

    @Autowired
    public RabbitListener(ReceiverUI receiverUI){
        this.receiverUI = receiverUI;
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "calculator.scoredetails.queue")
    public void receiveScoreDetails(StudentScoreDetail studentScoreDetail){
        receiverUI.displayScoreDetails(studentScoreDetail);
    }
}
