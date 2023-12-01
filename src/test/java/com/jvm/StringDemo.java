package com.jvm;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = s1.intern();
        String s3 = s1 + "c";
        String s4 = "abc";

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
    }

}
