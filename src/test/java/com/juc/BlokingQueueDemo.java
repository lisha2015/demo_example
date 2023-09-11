package com.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
  * @desc 阻塞队列-热身内容不是重点，jdk的api方法
  * @author 2023/9/4 0004 10:09 lisha
  */
public class BlokingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingDeque = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingDeque.add("a"));
        System.out.println(blockingDeque.add("b"));
        System.out.println(blockingDeque.add("c"));
        //  Queue full Exception
//        System.out.println(blockingDeque.add("xxx"));

        // 检查元素空不空
        System.out.println(blockingDeque.element());

        // 队列先进先出
        System.out.println(blockingDeque.remove());
        System.out.println(blockingDeque.remove());
        System.out.println(blockingDeque.remove());
        // 没有第四个元素 抛异常
//        System.out.println(blockingDeque.remove());

        // 返回布尔型的值
        BlockingQueue<String> blockingQueue1 = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue1.offer("a"));
        System.out.println(blockingQueue1.offer("b"));
        System.out.println(blockingQueue1.offer("c"));
        System.out.println(blockingQueue1.offer("xxx"));

        System.out.println(blockingQueue1.peek());

        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());
        System.out.println(blockingQueue1.poll());
    }
}
