package com.pattern.decorate1;

public class SportsCar extends CarDecorator{

    public SportsCar(Car decoratorCar) {
        super(decoratorCar);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Car.");
    }

}
