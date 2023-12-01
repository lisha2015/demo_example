package com.pattern.flyweight;

public class Client {

    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle("红色");
        Shape redCircle1 = ShapeFactory.getCircle("红色");
        Shape blueCircle = ShapeFactory.getCircle("蓝色");

        redCircle.draw();
        redCircle1.draw();
        blueCircle.draw();

    }
}
