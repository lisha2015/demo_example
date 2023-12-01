package com.pattern.observer;

public class ConcreteObserver2 implements Observer{

    private String name;

    public ConcreteObserver2(String name) {
        this.name = name;
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + "\t" + msg);
    }
}
