package com.pattern.observer1;

public class ConcreteObserver implements Observer{

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + "\t" + msg);
    }

}
