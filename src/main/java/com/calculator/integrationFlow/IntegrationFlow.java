package com.calculator.integrationFlow;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 20:52
 */
//运行时生成该接口的实现，知名默认消息通道
@MessagingGateway(defaultRequestChannel = "textInChannel")

public interface IntegrationFlow {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename,String data);
}
