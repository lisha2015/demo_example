package com.pattern1.visitor;

/**
  * @desc  访问者模式测试类
  * @author 2023/12/15 0015 9:57 lisha
  */
public class MainTest {

    public static void main(String[] args) {
        IVisitor v = new CenterVisitor();
        Triangle t = new Triangle(0, 0, 2, 0, 0, 2);
        Point pt = (Point) t.accept(v);
        System.out.println("面积为：" + t.getArea());
        System.out.println("周长为：" + t.getLength());
        System.out.println("中心为：" + pt.x + "\t" + pt.y);
        // 可知：如果我们再想增加一个求三角形外接圆半径功能，只需再定义一个新类实现IVisitor接口，在该类中完成求外接圆半径功能即可。

    }
}
