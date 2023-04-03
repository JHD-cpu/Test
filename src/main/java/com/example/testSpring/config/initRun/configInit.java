package com.example.testSpring.config.initRun;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class configInit implements ApplicationRunner {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}


