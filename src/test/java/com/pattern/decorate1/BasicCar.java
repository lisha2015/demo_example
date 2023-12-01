package com.pattern.decorate1;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("基本的小汽车");
    }
}
