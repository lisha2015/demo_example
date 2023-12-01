package com.atguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEnterLockDemo {

    static Object objectLockA = new Object();

    public static void m1(){
        new Thread(() -> {
            synchronized (objectLockA){
                System.out.println(Thread.currentThread().getName() + "\t" + "外层调用");
                synchronized (objectLockA){
                    System.out.println(Thread.currentThread().getName() + "\t" + "中层调用");
                    synchronized (objectLockA){
                        System.out.println(Thread.currentThread().getName() + "\t" + "内层调用");
                    }
                }
            }
        }, "t1").start();
    }

    public static void main(String[] args) {

//        m1();

        Lock lock = new ReentrantLock();

        lock.lock();
        System.out.println("lock----");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

        lock.unlock();
        lock.unlock();
        lock.unlock();
    }
}
