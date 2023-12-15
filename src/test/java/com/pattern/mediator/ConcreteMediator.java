package com.pattern.mediator;

public class ConcreteMediator implements Mediator{

    private Colleague colleague;

    public void setColleague(Colleague colleague) {
        this.colleague = colleague;
    }

    @Override
    public void receive(String message) {
        colleague.receiveMessage(message);
    }

}
