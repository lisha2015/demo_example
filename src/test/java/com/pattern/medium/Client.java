package com.pattern.medium;

public class Client {

    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(mediator);

        mediator.setConcreteColleagueA(concreteColleagueA);
        mediator.setConcreteColleagueB(concreteColleagueB);

        concreteColleagueA.send("111111");
        concreteColleagueA.receive("AAAAA");
        concreteColleagueB.send("222222");
        concreteColleagueB.receive("BBBBB");
    }
}
