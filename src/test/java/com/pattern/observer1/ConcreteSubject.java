package com.pattern.observer1;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{

    private List<Observer> observers;
    private String msg;
    public ConcreteSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.receive(msg);
        });
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}
