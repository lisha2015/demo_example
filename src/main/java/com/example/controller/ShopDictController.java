package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 可配置值字典项目 前端控制器
 * </p>
 *
 * @author lisha
 * @since 2023-06-14
 */
@RestController
@RequestMapping("/shopDict")
public class ShopDictController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

}
