package com.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
  * @desc
  * @author 2023/9/4 0004 11:45 lisha
  */

public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception{

        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }, "consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main叫停");
        try {
            myResource.stop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

class MyResource{
    private volatile boolean FLAG = true; // 默认开启，进行生产+ 消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    // 传接口不要传类
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 排查日志使用
        System.out.println(blockingQueue.getClass().getName());
    }

    // 生产
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            // 原子版递增
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功" );
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败" );
            }

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停了，表示FLAG为false 生成动作结束");
    }

    // 消费
    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }

        System.out.println(Thread.currentThread().getName() + "\t 消费队列蛋糕成功");
    }

    public void stop() throws Exception{
        this.FLAG = false;
    }

}
