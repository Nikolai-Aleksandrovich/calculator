package com.calculator.messageReciver;

import com.calculator.domain.StudentScoreDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 18:04
 */
@Component
@Slf4j
public class ReceiverUI {
    public void displayScoreDetails(StudentScoreDetail studentScoreDetail){
        //do something to element
        log.info(("Receive")+studentScoreDetail);
    }
}
