package com.pattern.medium;

public class ConcreteMediator implements Mediator{

    private ConcreteColleagueA concreteColleagueA;
    private ConcreteColleagueB concreteColleagueB;

    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if(colleague == concreteColleagueA){
            concreteColleagueA.receive(message);
        } else {
            concreteColleagueB.receive(message);
        }

    }
}
