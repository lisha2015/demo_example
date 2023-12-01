package com.pattern.decorate1;

public abstract class CarDecorator implements Car{

    protected Car decoratorCar;

    public CarDecorator(Car decoratorCar) {
        this.decoratorCar = decoratorCar;
    }


    @Override
    public void assemble() {
        decoratorCar.assemble();
    }
}
