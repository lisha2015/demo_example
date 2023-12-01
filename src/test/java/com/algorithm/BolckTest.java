package com.algorithm;

import lombok.SneakyThrows;
import org.apache.tomcat.jni.Time;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

// 不稳定
public class BolckTest {

    @Test
    public void waitFun(){
        while(true){
            System.out.println(new Random().nextInt(Integer.MAX_VALUE));
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println("put a");
                queue.put("a");

                System.out.println("put b");
                queue.put("b");

                System.out.println("put c");
                queue.put("c");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "aaa").start();

        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("获取到的值是：" + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("获取到的值是：" + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("获取到的值是：" + queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },"bbb").start();

        /**
         * 输出结果
         * put a
         * 获取到的值是：a
         * put b
         * put c
         * 获取到的值是：b
         * 获取到的值是：c
         *
         * Process finished with exit code 0
         */


    }

}
