package com.pattern.flyweight2;


import java.util.HashMap;
import java.util.Map;

public class ShapeFactory{

    public static final Map<String, Circle> cacheMap = new HashMap();
    private Circle circle;

    public ShapeFactory(Circle circle) {
        this.circle = circle;
    }

    public static Shape getShape(String color) {
        Circle circle = cacheMap.get(color);
        if(circle == null){
            circle = new Circle(color);
            cacheMap.put(color, circle);
            System.out.println("创建了新的圆颜色为：" + color);
        }
        return circle;
    }

}
