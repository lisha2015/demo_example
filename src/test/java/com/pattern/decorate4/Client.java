package com.pattern.decorate4;

public class Client {

    public static void main(String[] args) {

        MilkCoffee milkCoffee = new MilkCoffee(new SugarCoffee(new PlainCoffee()));
        milkCoffee.make();

    }
}
