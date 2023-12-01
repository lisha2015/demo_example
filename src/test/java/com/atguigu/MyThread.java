package com.atguigu;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyThread implements Callable {

    @Override
    public Object call() throws Exception {
        return 1024;
    }

    @SneakyThrows
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }
}
