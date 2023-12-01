package com.pattern.flyweight1;

public class Client {

    public static void main(String[] args) {

        Shape redShape1 = ShapeFactory.getSquare("红色");
        Shape redShape2 = ShapeFactory.getSquare("红色");
        Shape redShape3 = ShapeFactory.getSquare("蓝色");

        redShape1.draw();
        redShape2.draw();
        redShape3.draw();

    }
}
