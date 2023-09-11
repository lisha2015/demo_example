package com.juc;

import java.nio.ByteBuffer;

/**
 * @author 2023/9/6 0006 10:11 lisha
 * @desc
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory：" + (sun.misc.VM.maxDirectMemory() / 1024 / 1024) + "MB");
        // 配置的maxDirectMemory：3604MB
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ByteBuffer bb = ByteBuffer.allocate(6 * 1024 * 1024);
        /**
         * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
         * 	at java.nio.HeapByteBuffer.<init>(HeapByteBuffer.java:57)
         * 	at java.nio.ByteBuffer.allocate(ByteBuffer.java:335)
         * 	at com.juc.DirectBufferMemoryDemo.main(DirectBufferMemoryDemo.java:18)
         */

    }
}
