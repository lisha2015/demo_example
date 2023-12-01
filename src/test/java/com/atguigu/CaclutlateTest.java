package com.atguigu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Random;

public class CaclutlateTest {
    public static void main(String[] args) {

        double weight = 825;
        // cal(weight);

        int arr[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = new Random().nextInt(1000000);
        }

        long start = System.currentTimeMillis();
        System.out.println(start);
        // sortArr(arr);
        // secSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println("排序时间=" + (end - start));
        int[] array = {5, 3, 8, 4, 2};
        // secSort(array);

        insertSort(array);


    }


    public static BigDecimal cal(double weight){
        // double weight = 8532.00;
        double per_unit = 1000;
        int times = (int)(weight / per_unit);
        BigDecimal remainPrice = new BigDecimal(3);
        BigDecimal per_price = new BigDecimal(10);
        BigDecimal min_price = new BigDecimal(30);
        System.out.println(times);
        System.out.println( (int)times );

        BigDecimal fee = per_price.multiply(new BigDecimal(times));
        if (weight % per_unit > 0) {
            fee = fee.add(remainPrice);
        }

        if(fee.compareTo(min_price) <= 0){
            fee = min_price;
        }

        fee = fee.setScale(2, RoundingMode.DOWN);
        System.out.println("总计费用=" + fee);
        return fee;

    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void sortArr(int[] arr){
        // int[] arr = {4, 1, 6, 3, 61, 5};
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            // System.out.println("第" + i + "次排序 " + Arrays.toString(arr));
        }

        // System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序
     * @param arr
     */
    public static void secSort(int[] arr){
        if(arr.length == 0){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }

            if(i != min){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {

            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }

            arr[index + 1] = value;
        }


        System.out.println(Arrays.toString(arr));

    }
}
