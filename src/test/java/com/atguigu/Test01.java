package com.atguigu;

import org.junit.Test;

public class Test01 {

    @Test
    public void fun1(){

        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("2") + new String("2");
        s3.intern();
        String s4 = "22";
        String s44 = "22";
        System.out.println(s3 == s4);
        System.out.println(s3 == s44);
        System.out.println(s4 == s44);

        String s5 = new String("0") + new String("0");
        s5.intern();
        String s6 ="00";
        System.out.println(s5 == s6);

        String s7 = new String("ja") + new String("va");
        s7.intern();
        String s8 = "java";
        System.out.println(s7 == s8);

        String s9 = new String("JA") + new String("VA");
        s9.intern();
        String s10 = "JAVA";
        System.out.println(s9 == s10);

    }

    @Test
    public void fun2(){
        // s8.intern();
        String s7 = new String("ja") + new String("va");
        s7 = s7.intern();
        String s8 = "java";
        String s9 = s8.intern();
        System.out.println(s7 == s8);
        System.out.println(s7 == s9);
    }

    @Test
    public void fun3(){
        String s1 = new String("0") + new String("0");
        s1.intern();
        String s2 = "00";
        System.out.println(s1 == s2);

    }
}
