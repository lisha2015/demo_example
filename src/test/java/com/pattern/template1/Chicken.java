package com.pattern.template1;

public class Chicken extends Game{

    @Override
    public void start() {
        System.out.println("启动吃鸡");
    }

    @Override
    public void play() {

        System.out.println("玩吃鸡游戏");
    }

    @Override
    public void exit() {

        System.out.println("退出吃鸡游戏");
    }
}
