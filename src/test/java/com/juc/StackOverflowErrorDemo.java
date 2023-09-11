package com.juc;
/**
  * @desc
  * @author 2023/9/6 0006 9:44 lisha
 *  是异常还是错误？
  */

/**
 * 在Java虚拟机中，错误（Error）和异常（Exception）是两种不同的可抛出（throwable）对象，用于表示不同的问题或情况。
 *
 * 错误（Error）：
 *
 * 错误表示系统级别的问题，通常由虚拟机自身抛出。
 * 错误是无法恢复或处理的严重问题，可能导致应用程序崩溃或无法正常运行。
 * 例如，OutOfMemoryError 表示内存耗尽，StackOverflowError 表示堆栈溢出等。
 * 一般情况下，程序代码不应该捕获或处理错误，而应该让虚拟机来处理。
 * 异常（Exception）：
 *
 * 异常表示应用程序逻辑或运行时问题，可以由应用程序代码或外部库/框架抛出。
 * 异常可以通过捕获和处理来处理问题，并采取相应的措施。
 * 异常分为两种类型：受检异常（Checked Exception）和非受检异常（Unchecked Exception）。
 * 受检异常必须在方法签名中显式声明或捕获处理，否则编译器会报错。
 * 非受检异常也称为运行时异常（RuntimeException），不需要在方法签名中显式声明或捕获处理，编译器不会强制要求处理。
 * 总结：
 *
 * 错误（Error）表示严重的系统级问题，由虚拟机自身抛出，应用程序不应该捕获或处理。
 * 异常（Exception）表示应用程序级别的问题，可以由代码或外部库/框架抛出，需要捕获和处理。
 * 异常分为受检异常和非受检异常，受检异常必须在方法签名中显式声明或捕获处理，非受检异常则不需要。
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError(); // Exception in thread "main" java.lang.StackOverflowError
    }

}
