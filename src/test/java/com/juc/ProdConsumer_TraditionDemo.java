package com.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 2023/9/4 0004 10:43 lisha
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1交替来5轮
 * 1 线程    操作   资源类
 * 2 判断    干活   通知
 * 3 防止虚假唤醒机制
 * @desc 生产者消费者测试例
 *
 * synchronized 和lock区别？
 */
public class ProdConsumer_TraditionDemo {
    // 传统版本 sync wait notify


    // 新版本 lock await signal
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, "AA").start();

        new Thread(()->{
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, "BB").start();
    }


}

// 资源类
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            // 1 判断 用if判断线程变多会出错
            while (number != 0) {
                // 等待，不能生产
                condition.await();
            }

            // 2 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            // 3 通知唤醒
            this.condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            // 1 判断 用if判断线程变多会出错
            while (number == 0) {
                // 等待，不能消费
                condition.await();
            }

            // 2 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);

            // 3 通知唤醒
            this.condition.signalAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
