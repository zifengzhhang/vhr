package com.javaboy.vhr;

import com.javaboy.vhr.mapper.HrMapper;
import com.javaboy.vhr.pojo.Hr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VhrApplicationTests {

    @Autowired
    HrMapper hrMapper;

    @Test
    public void contextLoads() {
        Hr admin = hrMapper.loadUserByUsername("admin");
        System.out.println(admin.getName());
    }

}
