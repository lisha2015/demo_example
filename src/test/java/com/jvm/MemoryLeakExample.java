package com.jvm;

import java.util.Vector;

public class MemoryLeakExample {

    public static void main(String[] args) {
        Vector v = new Vector(200);
        for (int i = 1; i < 100; i++) {
            Object o = new Object();
            v.add(o);
            o = null;
        }
    }
}