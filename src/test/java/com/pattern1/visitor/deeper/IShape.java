package com.pattern1.visitor.deeper;

public interface IShape {

    float getArea();

    float getLength();

    Object accept(IVisitor v, String method);
}
