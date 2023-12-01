package com.atguigu;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

public class SortTest {

    public static Integer arr[] = {9, 3, 5, 4, 8, 1, 5};

    /**
     * 冒泡排序
     */
    @Test
    public void fun1() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] >= arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.asList(arr));

    }

    /**
     * 冒泡排序 - 改进
     */
    @Test
    public void fun2() {

        boolean swap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] >= arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }

            if(!swap){
                break;
            }
        }

        System.out.println(Arrays.asList(arr));

    }

    /**
     * 插入排序
     */
    @Test
    public void fun3() {

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // 将比 key 大的元素向后移动
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // 插入 key 到合适的位置
            arr[j + 1] = key;
        }

        System.out.println(Arrays.asList(arr));

    }

    /**
     * 插入排序
     */
    @Test
    public void fun4() {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.asList(arr));

    }

    /**
     * 选择排序
     */
    @Test
    public void fun5() {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }


        System.out.println(Arrays.asList(arr));
    }

    /**
     * 选择排序
     */
    @Test
    public void fun6() {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < arr.length; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


        System.out.println(Arrays.asList(arr));
    }

    public void fun7(){

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(nums1[i] < nums2[j]){
                    int key = nums1[i];
                    nums1[i] = nums2[j];
                    int l = m - n - i;
                    while (l >= 0) {
                        nums1[i + 1] = key;
                    }
                }
            }

        }

    }
}
