package com.pattern.decorate2;

public class Client {

    public static void main(String[] args) {

        MilkDecorate cafe = new MilkDecorate(new BasicCafe());
        cafe.makeCafe();

    }
}
