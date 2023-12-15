package com.pattern1.visitor.deeper;

public class Test4 {

    public static void main(String[] args) {
        IVisitor v = new ShapeVisitor(); // 定义访问者
        Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
        Point pt = (Point) t.accept(v, "getCenter");
        System.out.println("重心坐标x=" + pt.x + "\ty=" + pt.y);
        Float f = (Float) t.accept(v, "getInnerCircleR");
        System.out.println("内切圆半径R=" + f.floatValue());
    }
}
