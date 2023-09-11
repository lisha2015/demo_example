package com.juc;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

/**
  * @desc
  * @author 2023/9/4 0004 16:33 lisha
 * 死锁
  */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA, lockB), "ThreadAAA").start();
        new Thread(new HoldLockThread(lockB, lockA), "ThreadBBB").start();
    }
}

class HoldLockThread implements Runnable{

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    private String lockA;
    private String lockB;

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + "\t 尝试获得：" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + "\t 尝试获得：" + lockA);
            }
        }

        System.out.println(Thread.currentThread().getName() + " \t ");

    }
}
