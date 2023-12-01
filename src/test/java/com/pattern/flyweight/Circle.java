package com.pattern.flyweight;

public class Circle implements Shape {

    private String color;

    public Circle(String color) {
        this.color = color;
    }


    @Override
    public void draw() {
        System.out.println("画出了一个" + color + "颜色的圆");
    }
}
