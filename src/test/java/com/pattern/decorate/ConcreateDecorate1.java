package com.pattern.decorate;

public class ConcreateDecorate1 implements Decorate{

    private Component component;

    @Override
    public void operation() {
        System.out.println("操作之前做点什么1111111");
        component.operation();
        System.out.println("操作之后做点什么1111111");
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }
}
