package com.example.testSpring.config;

import com.example.testSpring.Listener.RedisStreamListenter;
import com.example.testSpring.config.staticData.StaticData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.stream.Consumer;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.ReadOffset;
import org.springframework.data.redis.connection.stream.StreamOffset;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.Subscription;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String,String> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
    RedisTemplate<String, String> objectObjectRedisTemplate = new RedisTemplate<>();
    objectObjectRedisTemplate.setConnectionFactory(lettuceConnectionFactory);
    objectObjectRedisTemplate.setDefaultSerializer(RedisSerializer.string());
    objectObjectRedisTemplate.setStringSerializer(RedisSerializer.string());
    return objectObjectRedisTemplate;
  }

  @Bean
  public StreamMessageListenerContainer streamMessageListenerContainer(
      LettuceConnectionFactory lettuceConnectionFactory) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    StreamMessageListenerContainer.StreamMessageListenerContainerOptions<
            String, MapRecord<String, String, String>>
            option =
            StreamMessageListenerContainer.StreamMessageListenerContainerOptions.builder()
                    .pollTimeout(Duration.ofSeconds(3))
                    .executor(executorService)
                    .serializer(RedisSerializer.string())
                    .batchSize(10)
                    .build();

     StreamMessageListenerContainer<String, ?>
        streamMessageListenerContainer =
            StreamMessageListenerContainer.create(lettuceConnectionFactory, option);
    streamMessageListenerContainer.start();
    return streamMessageListenerContainer;
  }

  @Bean
  public  Subscription subscription(StreamMessageListenerContainer streamMessageListenerContainer,RedisStreamListenter redisStreamListenter){
    return    streamMessageListenerContainer.receiveAutoAck(Consumer.from(StaticData.RedisGroup, StaticData.RedisGroupComsumer),
            StreamOffset.create(StaticData.RedisStream, ReadOffset.lastConsumed()), redisStreamListenter);
  }
}
