package com.pattern.medium;

public class ConcreteColleagueB extends Colleague{

    public ConcreteColleagueB(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("222发送消息：" + message);
    }

    @Override
    public void receive(String message) {
        System.out.println("222接收消息：" + message);
    }
}
