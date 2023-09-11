package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
  * @desc
  * @author 2023/9/4 0004 11:28 lisha
 *  AA打印5次 BB打印10次 CC 打印15次 循环打印5次
  */
public class SyncAndReentranLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                shareResource.print5();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                shareResource.print10();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 1; i <= 15; i++) {
                shareResource.print15();
            }
        }, "C").start();


    }
}

class ShareResource{
    private int number = 1; // A 1 B2 C3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            // 1 判断
            while (number != 1){
                c1.await();
            }
            // 2 干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            // 3 通知
            number = 2;
            c2.signal();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public void print10(){
        lock.lock();
        try {
            // 1 判断
            while (number != 2){
                c2.await();
            }
            // 2 干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            // 3 通知
            number = 3;
            c3.signal();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public void print15(){
        lock.lock();
        try {
            // 1 判断
            while (number != 3){
                c3.await();
            }
            // 2 干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }

            // 3 通知
            number = 1;
            c1.signal();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

}
