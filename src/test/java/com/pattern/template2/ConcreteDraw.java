package com.pattern.template2;

public class ConcreteDraw extends Draw{
    @Override
    void step1() {
        System.out.println("第一道工序");
    }

    @Override
    void step2() {
        System.out.println("第2道工序");
    }

    @Override
    void step3() {
        System.out.println("第3道工序");
    }

}
