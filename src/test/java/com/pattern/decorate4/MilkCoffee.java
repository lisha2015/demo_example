package com.pattern.decorate4;

public class MilkCoffee implements DecorateCoffee{

    private Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void add() {
    }

    @Override
    public void make() {
        System.out.println("加了点牛奶");
        coffee.make();
        System.out.println("变成了牛奶味咖啡");
    }
}
