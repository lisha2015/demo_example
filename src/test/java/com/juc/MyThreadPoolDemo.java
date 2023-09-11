package com.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 2023/9/4 0004 14:04 lisha
 * @desc
 */
public interface MyThreadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 一池5线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 一池5线程
        ExecutorService threadPool = Executors.newCachedThreadPool();// 一池5线程
        try {
            for (int i = 1; i <= 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }


}
