package com.atguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AbaDemo {

    private static AtomicReference atomicReference = new AtomicReference(100);
    private static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);
    public static void main(String[] args) {

        new Thread(()->{
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "aaa").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(atomicReference.compareAndSet(100, 2023) + "--\t" + atomicReference.get());
        }, "bbb").start();

        new Thread(()->{
            System.out.println("第1次版本号：" + atomicStampedReference.getStamp() + "--\t");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            atomicStampedReference.compareAndSet(100, 101,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("第2次版本号：" + atomicStampedReference.getStamp() + "--\t");
            atomicStampedReference.compareAndSet(101, 100,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("第3次版本号：" + atomicStampedReference.getStamp() + "--\t");
        }, "ccc").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("第11次版本号" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            boolean result = atomicStampedReference.compareAndSet(100, 2023,
                    stamp, stamp + 1);
            System.out.println("第4次版本号" + atomicStampedReference.getStamp() + "--\t");
            System.out.println("修改成功否：" + result + "当前值：" + atomicStampedReference.getReference());
        }, "ddd").start();

    }
}
