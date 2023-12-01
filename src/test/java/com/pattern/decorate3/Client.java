package com.pattern.decorate3;

public class Client {

    public static void main(String[] args) {

        IceDecorator iceCream = new MilkDecorater(new ChocolateDecorater(new BasicIceCream()));
        iceCream.makeCreame();
    }

}
