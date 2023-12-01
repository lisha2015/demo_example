package com.pattern.decorate2;

public class BasicCafe implements Cafe{
    @Override
    public void makeCafe() {
        System.out.println("制作原味咖啡");
    }
}
