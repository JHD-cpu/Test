package com.example.testSpring.Controller;

import com.alibaba.fastjson2.JSON;
import com.example.testSpring.dao.ElasticsearchDao;
import com.example.testSpring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elasticsearch")
@ConditionalOnProperty(prefix = "spring.elasticsearch", name = "open", havingValue = "true")
public class ElasticsearchController {
    @Autowired
    private ElasticsearchDao elasticsearchDao;

    @RequestMapping("/findAll")
    public String findAll(){
        Iterable<User> all = elasticsearchDao.findUserBy();

        return JSON.toJSONString(all);
    }
}
