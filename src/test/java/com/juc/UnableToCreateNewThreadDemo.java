package com.juc;

/**
  * @desc  windows下不好模拟，linux下创建1024个线程会崩溃
  * @author 2023/9/6 0006 10:30 lisha
  */
public class UnableToCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("*******i:" + i);
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "" + i).start();

        }
    }
}
