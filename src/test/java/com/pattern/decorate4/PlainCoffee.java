package com.pattern.decorate4;

public class PlainCoffee implements Coffee{
    @Override
    public void make() {
        System.out.println("原味咖啡");
    }
}
