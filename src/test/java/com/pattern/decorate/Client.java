package com.pattern.decorate;

public class Client {

    public static void main(String[] args) {
        ConcreateDecorate1 decorate1 = new ConcreateDecorate1();
        decorate1.setComponent(new ConcreateComponent1());
        decorate1.operation();

        ConcreateDecorate2 decorate2 = new ConcreateDecorate2();
        decorate2.setComponent(new ConcreateComponent2());
        decorate2.operation();
    }
}
