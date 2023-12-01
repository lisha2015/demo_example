package com.pattern.flyweight1;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    public static final Map<String, Shape> cacheShape = new HashMap<>();

    public static Shape getSquare(String color){
        Shape shape = cacheShape.get(color);
        if(shape == null){
            shape = new Square(color);
            System.out.println("创建了一个新正方形颜色为：" + color);
            cacheShape.put(color, shape);
        }

        return shape;
    }



}
