package com.calculator.email;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Yuyuan Huang
 * @create 2021-04-26 22:31
 */
@Data
@Component
@ConfigurationProperties(prefix = "calculator.email")
public class EmailProperties {
    private String username;
    private String password;
    private String host;
    private String mailbox;
    private long pollRate = 30000;
    public String getImapUrl(){
        return String.format("imaps://%s:%s@%s/%s",this.username,this.password,this.host,this.mailbox);
        //使用这个URL链接Email服务器并且轮询Email
    }
}
