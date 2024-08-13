package com.boot;

import com.example.HelloWorldApplication;
import com.example.service.ShopDictService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest(classes = {HelloWorldApplication.class})
public class DictTest {

    @Resource
    ShopDictService dictService;

    @Test
    public void test01(){
        long count = dictService.count();
        log.info("count:{}",count);
    }
}
