package com.calculator.messageReciver.Kafka.listener;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageReciver.ReceiverUI;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 20:35
 */
@Component
public class ScoreDetailsListener {
    private ReceiverUI receiverUI;

    @Autowired
    public ScoreDetailsListener(ReceiverUI receiverUI){
        this.receiverUI = receiverUI;
    }

    @KafkaListener(topics = "calculator.scoredetails.topic")
    public void scoreDetailsReceiver(StudentScoreDetail studentScoreDetail, Message<StudentScoreDetail> message){
        MessageHeaders headers = message.getHeaders();
        receiverUI.displayScoreDetails(studentScoreDetail);
    }
}
