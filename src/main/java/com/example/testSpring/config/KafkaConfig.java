package com.example.testSpring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
@Slf4j
@ConditionalOnProperty(name = "spring.kafka.open", havingValue = "true")
public class KafkaConfig {
  @Autowired KafkaTemplate<String, String> kafkaTemplate;

  public KafkaConfig() {
    log.info("KafkaConfig loading...");
  }

  public KafkaConfig(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @Scheduled(cron = "0/3 * * * * *")
  public void sendMessage() {
    kafkaTemplate
        .send(
            "my_topic",
            Thread.currentThread().getName(),
            String.valueOf(System.currentTimeMillis()))
        .addCallback(
            success -> {
              log.info("kafka send  success");
            },
            failure -> {
              log.info("kafka send  failure");
            });
  }
}
