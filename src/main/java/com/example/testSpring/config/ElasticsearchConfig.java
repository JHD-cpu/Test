package com.example.testSpring.config;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "spring.elasticsearch.open", havingValue = "true")
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
  @Value("${elasticsearch.host: '127.0.0.1:9900'}")
  private String host;

  @Override
  @Bean
  public RestHighLevelClient elasticsearchClient() {
    log.info("elasticsearchClientHost:" + host);
    ClientConfiguration build = ClientConfiguration.builder().connectedTo(host).build();
    RestHighLevelClient rest = RestClients.create(build).rest();
    log.info("RestHighLevelClient:" + JSON.toJSONString(rest));
    return rest;
  }
}
