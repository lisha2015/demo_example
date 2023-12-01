package com.pattern.stratagy;

/**
  * @desc 调用策略方法
  * @author 2023/11/28 0028 9:54 lisha
  */
public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setStratagy(new ConcreateStratagy1());
        context.operation();

        context.setStratagy(new ConcreateStratagy2());
        context.operation();
    }
}
