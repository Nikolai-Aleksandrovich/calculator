package com.calculator.messageReciver.Jms.Listener;

import com.calculator.domain.StudentScoreDetail;
import com.calculator.messageReciver.ReceiverUI;
import com.calculator.messageReciver.ScoreDetailsReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 18:07
 */
@Component
public class ScoreDetailsListener {
    private ReceiverUI receiverUI;
    @Autowired
    public ScoreDetailsListener(ReceiverUI receiverUI){
        this.receiverUI = receiverUI;
    }
    @JmsListener(destination = "calculator.scoredetails.queue")
    public void receiveScoreDetails(StudentScoreDetail studentScoreDetail){
        receiverUI.displayScoreDetails(studentScoreDetail);
    }
}
