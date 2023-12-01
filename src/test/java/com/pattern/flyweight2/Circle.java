package com.pattern.flyweight2;

public class Circle implements Shape{

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画一个圆颜色为：" + color);
    }
}
