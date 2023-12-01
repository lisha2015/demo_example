package com.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static final Map<String, Shape> shapeCache = new HashMap<>();

    public static Shape getCircle(String color){
        Shape circle = shapeCache.get(color);
        if (circle == null){
            circle = new Circle(color);
            shapeCache.put(color, circle);
            System.out.println("Creating a new circle with color: " + color);
        }
        return circle;
    }
}
