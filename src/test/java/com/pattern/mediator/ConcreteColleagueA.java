package com.pattern.mediator;

public class ConcreteColleagueA implements Colleague{
    @Override
    public void receiveMessage(String message) {
        System.out.println("同事AAA接收到消息：" + message);

    }
}
