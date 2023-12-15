package com.pattern.mediator;

public class ConcreteColleagueB implements Colleague{
    @Override
    public void receiveMessage(String message) {
        System.out.println("同事BBB接收到消息：" + message);

    }
}
