package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller
public class ErrorController {

    // @RequestMapping("/")
    public ModelAndView error() {
        ModelAndView modelAndView = new ModelAndView("error/404");
        modelAndView.addObject("message", "页面不存在");
        return modelAndView;
    }
}
