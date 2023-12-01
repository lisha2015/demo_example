package com.pattern.observer1;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver("观察者1");
        ConcreteObserver observer2 = new ConcreteObserver("观察者2");
        ConcreteObserver observer3 = new ConcreteObserver("观察者3");

        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);

        subject.setMsg("消息来了");
        subject.remove(observer1);
        subject.setMsg("观察者1被移除了");
    }
}
