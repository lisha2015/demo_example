package com.pattern.stratagy1;

/**
  * @desc  调用策略方法
  * @author 2023/11/28 0028 9:59 lisha
  */
public class Client {
    public static void main(String[] args) {
        StratagyContext context = new StratagyContext();
        context.setStratagy(new StratagyImpl1());
        context.operation();

        context.setStratagy(new StratagyImpl2());
        context.operation();
    }
}
