package com.example.testSpring.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class RedisStreamListenter implements StreamListener<String, MapRecord<String,String,String>> {

    private Logger logger=LoggerFactory.getLogger(RedisStreamListenter.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


     @Override
    public void onMessage(MapRecord<String, String, String> message) {
         logger.info("redis Stream 消息监听开始");
        Object value = message.getValue();
        logger.info("redis Stream 消息监听器:"+value);
    }
}
