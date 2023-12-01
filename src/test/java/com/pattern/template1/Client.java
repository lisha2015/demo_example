package com.pattern.template1;

public class Client {

    public static void main(String[] args) {

        Wangzhe wangzhe = new Wangzhe();
        wangzhe.start();
        wangzhe.operation();

        Chicken chicken = new Chicken();
        chicken.operation();
    }
}
