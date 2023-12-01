package com.pattern.decorate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConcreateComponent2 implements Component{

    @Override
    public void operation() {
        new ClassPathXmlApplicationContext("aaa.xml");
        System.out.println("操作222222222");
    }
}
