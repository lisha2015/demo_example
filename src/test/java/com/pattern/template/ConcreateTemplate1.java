package com.pattern.template;

public class ConcreateTemplate1 extends Template{
    @Override
    public void start() {
        System.out.println("开始游戏111");
    }

    @Override
    public void play() {
        System.out.println("玩游戏111");
    }

    @Override
    public void exit() {
        System.out.println("退出游戏111");
    }

}
