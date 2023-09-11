package com.example.hello;

import com.example.HelloWorldApplication;
import com.example.entity.ShopDict;
import com.example.service.ShopDictService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = {HelloWorldApplication.class})
@Slf4j
public class DictTest {

    @Autowired
    ShopDictService dictService;

    @Test
    public void testList() {
        List<ShopDict> list = dictService.list();
        list.forEach(item -> {
            System.out.println(item);
        });

    }
}
