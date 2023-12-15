package com.jvm;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = new String("a") + new String("b");
        String s3 = "ab";
        String s2 = s3.intern();

        System.out.println(s1 == s3);
    }

    @Test
    public void fun1(){

        for (int i = 0; i < 10; i++) {
            String random = RandomStringUtils.randomAlphabetic(10);
            System.out.println(random);
        }
    }

}
