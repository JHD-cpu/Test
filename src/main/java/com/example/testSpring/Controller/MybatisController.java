package com.example.testSpring.Controller;

import com.example.testSpring.entity.User;
import com.example.testSpring.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/mybatis")
public class MybatisController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @PostMapping("/insert")
    @ResponseBody
    public boolean insert(@RequestBody List<User> user){
         userMapper.inster(user);
        return true;
    }
    @PostMapping("/delete")
    public boolean delete(@RequestParam String id ){
        userMapper.deleteById(id);
        return true;
    }
}
