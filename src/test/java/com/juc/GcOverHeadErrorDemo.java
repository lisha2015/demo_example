package com.juc;

import java.util.ArrayList;
import java.util.List;

/**
  * @desc
  * @author 2023/9/6 0006 9:56 lisha
  */
public class GcOverHeadErrorDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("*****i:" + i);
            throw new RuntimeException(e);
            // Exception in thread "main" java.lang.RuntimeException: java.lang.OutOfMemoryError: GC overhead limit exceeded
        }

    }
}
