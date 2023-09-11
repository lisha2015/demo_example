package com.juc;

import java.util.concurrent.*;

public class MyThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1l,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                // 4种抛弃策略
                new ThreadPoolExecutor.DiscardOldestPolicy());


        try {
            for (int i = 1; i <= 10; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 业务办理");
                });

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
