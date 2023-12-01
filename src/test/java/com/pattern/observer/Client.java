package com.pattern.observer;

public class Client {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver1 observer1 = new ConcreteObserver1("Observer 1");
        ConcreteObserver2 observer2 = new ConcreteObserver2("Observer 2");

        subject.add(observer1);
        subject.add(observer2);

        subject.setMessage("Hello, observers!");

        subject.remove(observer1);
        //
        subject.setMessage("Observer 1 is removed.");
    }
}
