package com.pattern1.visitor.deeper;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Method;

public class ShapeVisitor implements IVisitor {

    public Object getCenter(Triangle t) {
        Point pt = new Point();
        pt.x = (t.x1 + t.x2 + t.x3) / 3;
        pt.y = (t.y1 + t.y2 + t.y3) / 3;
        return pt;
    }

    public Float getInnerCircleR(Triangle triangle) {
        float area = triangle.getArea();
        float len = triangle.getLength();
        return new Float(2.0f * area / len);
    }

    @Override
    public Object visit(Triangle t, String method) {
        Object result = null;
        try {
            Class classInfo = this.getClass();
            Method mt = classInfo.getMethod(method, Triangle.class);
            result = mt.invoke(this, new Object[]{t});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
