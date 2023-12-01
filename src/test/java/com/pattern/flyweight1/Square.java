package com.pattern.flyweight1;

public class Square implements Shape{

    private String color;

    public Square(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("画了一个正方形颜色为：" +  color);
    }
}
