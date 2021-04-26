package com.calculator.messageSender.Kafka;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageSender.ScoreMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 20:26
 */
@Profile("kafka-template")
@Service
public class KafkaScoreDetailsMessagingService implements ScoreMessageService {
    private KafkaTemplate<String,StudentScoreDetail> kafkaTemplate;
    @Autowired
    public KafkaScoreDetailsMessagingService(KafkaTemplate<String,StudentScoreDetail> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public void sendScoreDetail(StudentScoreDetail studentScoreDetail) {
        kafkaTemplate.sendDefault(studentScoreDetail);
    }
}
