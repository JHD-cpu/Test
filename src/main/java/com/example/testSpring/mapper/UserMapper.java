package com.example.testSpring.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testSpring.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper  extends BaseMapper<User> {

    List<User> findAll();

    void inster(@Param("list") List<User> userList);
}
