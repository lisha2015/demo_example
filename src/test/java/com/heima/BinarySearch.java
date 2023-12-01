package com.heima;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 9, 11, 20, 34, 45};
        int target = 20;
        System.out.println(binarySearchBase(arr, target));

    }

    public static int binarySearchBase(int[] arr, int target){
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if(target < arr[m]){
                j = m - 1;
            } else if(arr[m] < target){
                i = m + 1;
            } else {
                return m;
            }
        }

        return -1;
    }

    @Test
    public void fun1(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        list.add(2,
                5);

        System.out.println(Arrays.asList(list));
        System.out.println(list.size());
    }

    @Test
    public void fun2(){

        // String s1 = "JAVA";
        // s1.intern();
        String s2 = new String("JA") + new String("VA");
        // // s1.intern();
        s2.intern();
        String s3 = new String("JAVA");
        // s3.intern();
        // System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        // System.out.println(s1 == s2);
    }
}
