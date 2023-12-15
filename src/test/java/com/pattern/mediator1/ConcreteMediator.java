package com.pattern.mediator1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator{

    public List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague){
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(Colleague colleague, String message) {

    }

    @Override
    public void receiveMessage(Colleague colleague, String message) {

    }
}
