package com.shun.mybatisplusstudy;

import com.shun.mybatisplusstudy.mapper.UserMapper;

import com.shun.mybatisplusstudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusStudyApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setName("东方");
        user.setAge(23);
        user.setEmail("12345@qq.com");
        userMapper.insert(user);
    }

    @Test
    void updateUser() {
        User user = userMapper.selectById(1411105004960518145L);
        user.setAge(200);
        userMapper.updateById(user);
    }


}
