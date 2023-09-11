package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
  * @desc
  * @author 2023/9/4 0004 13:24 lisha
  */

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new myThred());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new myThred());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask2, "BB").start();
        int result02 = futureTask.get();
        int result01 = 100;
        System.out.println("最终结果=" + (result01 + result02));
        System.out.println(Thread.currentThread().getName() + "******");
    }
}

class myThred implements Callable<Integer>{


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t come in call method……");
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}
