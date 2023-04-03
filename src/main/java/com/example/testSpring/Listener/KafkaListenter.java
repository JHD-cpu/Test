package com.example.testSpring.Listener;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@ConditionalOnProperty(name = "spring.kafka.open", havingValue = "true")
public class KafkaListenter   {


    @KafkaListener(topics = {"my_topic"},groupId = "my_topic_group")
    public void myTopicMessageListener(List<ConsumerRecord<String, String>> messages){
        for (ConsumerRecord<String, String> message : messages) {
            String topic = message.topic();
            String key = message.key();
            String value = message.value();
            log.info("kafka 监听：topic="+topic);
            log.info("kafka 监听：key="+key);
            log.info("kafka 监听：value="+value);

        }
    }

}
