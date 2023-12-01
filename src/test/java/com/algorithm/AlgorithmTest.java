package com.algorithm;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmTest {

    /**
     * twoSum
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2,5,8,3,56,6,7,4};
        int sum = 10;
        // 暴力算法
        // for (int i = 0; i < arr.length; i++) {
        //     int temp = arr[i];
        //     for (int j = i + 1; j < arr.length; j++) {
        //         if(temp + arr[j] == sum){
        //             System.out.println("i=" + i + "---j=" + j );
        //         }
        //     }
        // }

        // hash算法
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer remain = sum - arr[i];
            if(map.containsKey(remain)){
                System.out.println(map.get(remain) + "--" + i);
            }
            map.put(arr[i], i);
        }
    }
}
