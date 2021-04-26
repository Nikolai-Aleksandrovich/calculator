package com.calculator.integrationFlow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.swing.event.ChangeListener;
import java.io.File;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 21:01
 */
@Configuration
public class FileWriterIntegrationConfig {

    //转换器
    @Profile("javaconfig")
    @Bean
    @Transformer(inputChannel = "textInChannel",outputChannel = "fileWriterChannel")
    public GenericTransformer<String,String> upperCaseTransformer(){
        return String::toUpperCase;
    }

    //文件写入器
    @Profile("javaconfig")
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWriter(){
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("/tmp/integrationFlow/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

    @Bean
    public MessageChannel textInChannel(){
        return  new DirectChannel();
    }
    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }

    //使用DSL配置，使用一个bean配置整个流
    @Profile("javadsl")
    @Bean
    public IntegrationFlow fileWriterFlow(){
        return IntegrationFlows
                .from(MessageChannels.direct("textInChannel"))
                .<String,String>transform(String::toUpperCase)
                .channel(MessageChannels.direct("fileWriterChannel"))
                .handle(Files
                        .outboundAdapter(new File("/tmp/integrationFlow/files"))
                        .fileExistsMode(FileExistsMode.APPEND)
                        .appendNewLine(true))
                .get();
    }

}
