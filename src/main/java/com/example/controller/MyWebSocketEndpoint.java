package com.example.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
@Component
public class MyWebSocketEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket连接已建立");
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("收到消息：" + message);
        return "服务器已接收到消息：" + message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("WebSocket连接已关闭：" + closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket错误：" + throwable.getMessage());
    }

}
