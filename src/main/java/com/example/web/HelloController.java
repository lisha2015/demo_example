package com.example.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/sayHello")
    public String hello(){
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloController.class);
        context.getBean("aaa");
        return "Hello world";
    }
}
