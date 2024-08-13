package com.example.controller;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

// @RestController
public class MyCustomErrorController implements ErrorController {

    // @RequestMapping("/error")
    public ResponseEntity<String> handleError(HttpServletRequest request) {
        // 获取错误状态码
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (statusCode != null && statusCode == HttpStatus.NOT_FOUND.value()) {
            // 自定义处理404错误逻辑
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Custom 404 Not Found");
        }

        // 其他错误情况下的处理逻辑
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }

    public String getErrorPath() {
        return "/error";
    }
}
