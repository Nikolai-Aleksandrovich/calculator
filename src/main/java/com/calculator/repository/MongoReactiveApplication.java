package com.calculator.repository;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.internal.MongoClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * @author Yuyuan Huang
 * @create 2021-04-30 21:45
 */
@EnableReactiveMongoRepositories
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }
    @Override
    protected String getDatabaseName() {
        return "reactive";
    }
}
