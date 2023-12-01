package com.pattern.decorate1;

public class LuxuryCar extends CarDecorator{

    public LuxuryCar(Car decoratorCar) {
        super(decoratorCar);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Luxury Car.");
    }

}
