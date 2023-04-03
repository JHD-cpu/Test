package com.example.testSpring.dao;

import com.example.testSpring.entity.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(prefix = "spring.elasticsearch", name = "open", havingValue = "true")
public interface ElasticsearchDao extends ElasticsearchRepository<User,String> {
      List<User> findUserBy();
}
