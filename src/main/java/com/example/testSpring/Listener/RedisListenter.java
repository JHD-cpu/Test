package com.example.testSpring.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

@Component
public class RedisListenter implements MessageListener {

    private final Logger logger= LoggerFactory.getLogger(RedisListenter.class);

    @Autowired
    private RedisTemplate<String,String> redisTemplate;



    @Override
    public void onMessage(Message message, byte[] pattern) {
        RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        String deserialize = stringSerializer.deserialize(message.getBody());
        logger.info("redis 消息监听:"+deserialize);
    }
}
