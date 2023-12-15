package com.pattern1.visitor;

public class MainTest {

    public static void main(String[] args) {
        IVisitor v = new CenterVisitor();
        Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
        Point pt = (Point) t.accept(v);
        System.out.println("面积为：" + t.getArea());
        System.out.println("周长为：" + t.getLength());
        System.out.println("中心为：" + pt.x + "\t" + pt.y);

    }
}
