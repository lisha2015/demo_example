package com.atguigu;

public class LockSupportDemo {

    static Object objectLock = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "\t" + "----- come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {

                }
                System.out.println(Thread.currentThread().getName() + "\t" + "被唤醒");
            }

        }, "A").start();

        new Thread(()->{
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "----通知");
            }
        }, "B").start();

    }
}
