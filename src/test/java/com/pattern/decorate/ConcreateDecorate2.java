package com.pattern.decorate;

public class ConcreateDecorate2 implements Decorate{

    private Component component;

    @Override
    public void operation() {
        System.out.println("操作之前做点什么2222222");
        component.operation();
        System.out.println("操作之后做点什么2222222");
    }

    @Override
    public void setComponent(Component component) {
        this.component = component;
    }
}
