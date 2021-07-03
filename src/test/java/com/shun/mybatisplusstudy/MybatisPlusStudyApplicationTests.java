package com.shun.mybatisplusstudy;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        user.setName("东方bubai");
        user.setAge(24);
        user.setEmail("12345@qq.com");
        userMapper.insert(user);
    }

    @Test
    void updateUser() {
        User user = userMapper.selectById(1411111134457733121L);
        user.setAge(200);
        userMapper.updateById(user);
    }

    @Test
    void deleteUser() {
        userMapper.deleteById(1411111134457733121L);
    }

    @Test
    void limit() {
        Page<User> page = new Page<User>(1, 3);
        userMapper.selectPage(page, null);

        page.getCurrent();//current page
        page.getRecords();//all data
        page.getSize();//how many data per page
        page.getTotal();//number of total records
        page.getPages();//number of total pages

        page.hasNext();//if has next page
        page.hasPrevious();//if has next page
    }


}
