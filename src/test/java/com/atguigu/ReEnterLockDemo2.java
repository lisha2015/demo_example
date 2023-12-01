package com.atguigu;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEnterLockDemo2 {

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(()->{
            lock.lock();
            lock.lock();
            try {
                System.out.println("====外层");
                lock.lock();
                try {
                    System.out.println("====内层");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);

            } finally {
//                lock.unlock();
                lock.unlock();
            }

        }, "t1").start();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "\t ===调用开始");
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
