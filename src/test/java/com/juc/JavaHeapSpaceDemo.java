package com.juc;

import java.util.Random;

/**
  * @desc new一个大对象即可
  * @author 2023/9/6 0006 9:52 lisha
  */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "abcde";
        while (true){
            str += str + new Random().nextInt(11111111) + new Random().nextInt(22222222);
            str.intern();
        }
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

    }

}
