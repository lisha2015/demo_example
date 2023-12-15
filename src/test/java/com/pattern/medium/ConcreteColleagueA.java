package com.pattern.medium;

public class ConcreteColleagueA extends Colleague{

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        System.out.println("111发送消息：" + message);
    }

    @Override
    public void receive(String message) {
        System.out.println("111接收消息：" + message);
    }
}
