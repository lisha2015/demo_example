package com.algorithm;

import java.util.Random;

public class DeadLoop1 {
    public static void main(String[] args) {
        while(true){
            System.out.println(new Random().nextInt(Integer.MAX_VALUE));
        }
    }
}
