package com.algorithm;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareData {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition conditiona = lock.newCondition();
    Condition conditionb = lock.newCondition();
    Condition conditionc = lock.newCondition();
    private volatile int num = 0;

    @Test
    public void fun() {


            new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    inc();
                }
            }, "AAA").start();

            new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    dec();
                }
            }, "BBB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                inc();
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                dec();
            }
        }, "DDD").start();

        // try {
        //     TimeUnit.SECONDS.sleep(5);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

    }

    public void inc(){
        try {
            lock.lock();
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println("num++=" + num);
            condition.signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void dec(){
        try {
            lock.lock();
            while (num == 0) {
                condition.await();
            }
            num--;
            System.out.println("num--=" + num);
            condition.signalAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    private int number = 1;

    @Test
    public void fun2(){
        new Thread(()->{
            try {
                lock.lock();
                while (number != 1){
                   conditiona.await();
                }
                printA();
                number = 2;
                conditionb.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        },"AAA").start();

        new Thread(()->{
            try {
                lock.lock();
                while (number != 2){
                   conditionb.await();
                }
                printB();
                number = 3;
                conditionc.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        },"BBB").start();
        new Thread(()->{
            try {
                lock.lock();
                while (number != 3){
                    conditionc.await();
                }
                printC();
                number = 1;
                conditiona.signal();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        },"CCC").start();

    }

    public void printA(){
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "A");
        }
    }

    public void printB(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "B");
        }
    }

    public void printC(){
        for (int i = 0; i < 15; i++) {
            System.out.println(i + "C");
        }
    }
}
