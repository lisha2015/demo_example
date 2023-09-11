package com.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
  * @desc  多线程与countDownLatch相反。开会有先到的有后到的，只有等所有人到齐了再开始
  * @author 2023/9/4 0004 9:53 lisha
  */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("***召唤神龙");
        });

        for (int i = 1; i <= 7 ; i++) {
            final int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + finalI + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
