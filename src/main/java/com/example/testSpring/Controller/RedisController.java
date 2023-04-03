package com.example.testSpring.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.testSpring.config.staticData.StaticData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StreamOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Component
@RestController
@RequestMapping("/redis")
public class RedisController {
  private Logger logger=LoggerFactory.getLogger(RedisController.class);
  @Autowired
  private RedisTemplate<String, String> redisTemplate;




  @RequestMapping("/put")
  public Boolean putRedisString(@RequestParam String name, @RequestParam String value) {
    try {
      redisTemplate.opsForValue().set(name, value);
    } catch (Exception e) {
      return false;
    }

    return true;
  }

  @PostMapping(value = "/get",produces = "application/json")
  public String getRedisString( @RequestBody(required = true)  String name) {
    return redisTemplate.opsForValue().get(name);
  }

  @RequestMapping("/putHash")
  public Boolean putRedisHash(
      @RequestParam String name, @RequestParam String key, @RequestParam String value) {

    try {
      redisTemplate.opsForHash().put(name, key, value);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @RequestMapping("/getHash")
  public String getRedisHash(@RequestParam String name, @RequestParam String key) {

    return (String) redisTemplate.opsForHash().get(name, key);
  }

  @RequestMapping("/putMQMessage")
  public Boolean putMQMessage(@RequestParam String key, @RequestParam String value) {
     redisTemplate.convertAndSend(key,value);
    return true;
  }
  @RequestMapping("/createComsumer")
  @ResponseBody
  public Object createComsumer(@RequestParam String streamName ,
                                      @RequestParam String group, @RequestParam String comsumer ) {
    StreamOperations<String, Object, Object> streamOperations = redisTemplate.opsForStream();

    List<MapRecord<String, Object, Object>> read = streamOperations.read(StreamOffset.create(StaticData.RedisStream, ReadOffset.from("0-0")));
      for ( MapRecord<String, Object, Object> record : read) {
        String s = JSON.toJSONString(record.getValue());
        logger.info("读取消息："+record.getId().getValue()+":"+s);
        streamOperations.acknowledge(record.getStream(),record);
        streamOperations.delete(record);
      }
    return read;
  }
  @RequestMapping("/putStreamMessageSend")
  @ResponseBody
  public RecordId putStreamMessageSend(@RequestParam String key,  @RequestParam String value ) {

    /**
     * 生产发送消息
     */
    HashMap<String, String> message = new HashMap<>();
    message.put(key,value);
    RecordId add = redisTemplate.opsForStream().add(StaticData.RedisStream,message);
    return add;
  }
}
