package com.atguigu;

public class ReEnterLockDemo1 {

    static Object objectLockA = new Object();

    public static void m1(){
        System.out.println("====外");
        m2();
    }

    private static void m2() {
        System.out.println("===中");
        m3();
    }

    private static void m3() {
        System.out.println("====内");
    }

    public static void main(String[] args) {
        m1();
    }
}
