package com.pattern.decorate4;

public class SugarCoffee implements DecorateCoffee{

    private Coffee coffee;

    public SugarCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void add() {
    }

    @Override
    public void make() {
        System.out.println("加了点糖");
        coffee.make();
        System.out.println("变成了甜味咖啡");
    }
}
