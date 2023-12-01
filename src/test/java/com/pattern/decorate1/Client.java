package com.pattern.decorate1;

public class Client {

    public static void main(String[] args) {
        SportsCar car = new SportsCar(new LuxuryCar(new BasicCar()));
        car.assemble();
    }
}
