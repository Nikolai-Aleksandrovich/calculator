package com.calculator.messageSender;

import com.calculator.domain.StudentScoreDetail;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 17:23
 */
public interface ScoreMessageService {
    void sendScoreDetail(StudentScoreDetail studentScoreDetail);
}
