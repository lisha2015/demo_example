package com.pattern.flyweight2;


public class Client {

    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("红色");
        Shape shape2 = ShapeFactory.getShape("红色");
        Shape shape3 = ShapeFactory.getShape("蓝色");
        shape1.draw();
        shape2.draw();
        shape3.draw();
    }
}
