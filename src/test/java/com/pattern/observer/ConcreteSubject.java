package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{

    private List<Observer> list;
    private String message;

    public ConcreteSubject() {
        this.list = new ArrayList<>();

    }

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        if(list.size() == 0){
            System.out.println("没有观察者");
        }
        list.forEach(observer -> {
            observer.receive(msg);
        });
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers(message);
    }
}
