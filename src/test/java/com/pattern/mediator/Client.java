package com.pattern.mediator;

public class Client {

    public static void main(String[] args) {

        ConcreteMediator mediator = new ConcreteMediator();
        mediator.setColleague(new ConcreteColleagueA());
        mediator.receive("发给同事A的消息");
    }
}
