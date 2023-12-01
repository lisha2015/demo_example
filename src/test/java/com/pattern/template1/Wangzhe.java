package com.pattern.template1;

public class Wangzhe extends Game{

    @Override
    protected void start() {
        System.out.println("启动王者");
    }

    @Override
    void play() {

        System.out.println("玩王者");
    }

    @Override
    void exit() {

        System.out.println("退出王者");
    }
}
