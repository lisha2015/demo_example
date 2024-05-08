package com.leecode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class Solution {

    public static void main(String[] args) {

        int[] num1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int m = num1.length;
        int[] num2 = {2, 4, 6, 8};
        int n = num2.length;

        int index = 0;
        for (int i = 0; i < m; i++) {
            int temp1 = num1[i];
            for (int j = index; j < n; j++) {
                int temp2 = num2[j];
                if (temp1 > temp2) {
                    right(num1, temp2, i);
                    index++;
                } else {
                    break;
                }

            }

        }

        System.out.println(Arrays.toString(num1));


    }

    public static void right(int nums[], int num, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;

    }

    public static void left(int nums[], int num, int index) {
        for (int i = nums.length - 1; i > index - 1; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;

    }

    @Test
    public void test01() {
        int[] arr = {1, 3, 5, 7, 0, 0};
        int num = 8;
        int index = 3;
        // left(arr, num, index);
        putOrder(arr, num);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param nums1 要合并的数组
     * @param num   要放进去的元素值
     */
    public static void putOrder(int nums1[], int num) {
        boolean flag = false;
        for (int i = 0; i < nums1.length - 1; i++) {
            int temp = nums1[i];
            // 存在A中比B大的元素
            if (temp > num) {
                for (int j = nums1.length - 1; j > i; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[i] = num;
                flag = true;
                break;
            }
            if (temp == num) {
                continue;
            }

        }
        // 不存在A中比B大的元素
        if (!flag) {
            for (int i = 0; i < nums1.length; i++) {
                int temp = nums1[i];
                if (nums1[i + 1] < temp) {
                    // 为0的第一个元素放进当前值
                    nums1[i + 1] = num;
                    break;
                }
            }

        }

    }

    @Test
    public void test02() {
        // int[] num1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] num1 = {0};
        int m = num1.length;
        // int[] num2 = {-1, 0, 6, 8};
        int[] num2 = {1};
        int n = num2.length;
        for (int i = 0; i < n; i++) {
            putOrder(num1, num2[i]);
        }
        System.out.println(Arrays.toString(num1));
    }


    @Test
    public void test03() {
        // int[] num1 = {1, 3, 5, 7, 0, 0, 0, 0};
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        // int[] num2 = {-1, 0, 6, 8};
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int total = m;
        for (int a = 0; a < n; a++) {
            int num = nums2[a];
            boolean flag = false;
            for (int i = 0; i < m - 1; i++) {
                int temp = nums1[i];
                // 存在A中比B大的元素
                if (temp > num) {
                    for (int j = nums1.length - 1; j > i; j--) {
                        nums1[j] = nums1[j - 1];
                    }
                    nums1[i] = num;
                    flag = true;
                    total += 1;
                    break;
                }
            }

            // 不存在A中比B大的元素
            if (!flag) {
                nums1[total] = num;
                total += 1;
            }
        }

    }


    @Test
    public void test04() {

        int[] arr = {2, 3, 5, 4, 1, 3, 4, 5, 14, 4};
        int num = 5;
        System.out.println(removeElement(arr, num));

    }

    /**
     * 在数组原位置移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for (int num : nums) {
            if (num != val) {
                nums[index] = num;
                index++;
            }
        }
        return index;
    }


    /**
     * @param nums
     * @return
     * @url: https://leetcode.cn/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp1 = nums[index];
            int temp2 = nums[i];
            if (temp1 != temp2) {
                nums[++index] = temp1;
            }

        }


        int total = index + 1;
        System.out.println(total);
        System.out.println(Arrays.toString(nums));
        return total;
    }

    @Test
    public void removeDuplicates() {
        int[] arr = {1, 1, 2};
        removeDuplicates(arr);
    }

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test05() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicatest2(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicatest2(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int val1 = nums[index];
            int val2 = nums[i];
            if (val1 != val2) {
                nums[++index] = val2;
                count = 0;
            } else {
                count++;
                if (count == 1) {
                    nums[++index] = val2;
                }
            }
        }

        return index + 1;
    }

    /**
     * https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test06() {

        int arr[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));

    }

    public int majorityElement(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int half = len / 2;
        Arrays.sort(nums);

        int index = 0;
        int count = 1;
        int total = 0;
        int val = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index++] == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            if (count > half) {
                val = nums[i];
                total++;
            }
        }

        return val;

    }

    /**
     * https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test07() {

        int arr[] = {-1, -100, 3, 99};
        // int arr[] = {1,2,3};
        int k = 2;
        rotate(arr, k);
        // System.out.println(Arrays.toString(arr));

    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = nums[(k + i) % length];
        }
        System.arraycopy(arr, 0, nums, 0, length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test08() {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int temp1 = prices[i];
            if(minPrice > temp1){
                minPrice = temp1;
            } else if (profit < temp1 - minPrice) {
                profit = temp1 - minPrice;
            }
        }

        return profit;
    }

    /**
     * 买卖股票最佳时机2
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test09() {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(arr));
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i] < prices[i+1]){
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

    /**
     * 跳跃游戏
     * https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test10() {
        int arr[] = {2, 0, 0};
        System.out.println(canJump(arr));
    }

    public boolean canJump(int[] nums) {
        // if (nums == null) {
        //     return false;
        // }
        // int k = 0;
        // for (int i = 0; i <= k; i++) {
        //     int temp = i + nums[i];
        //     k = Math.max(k, temp);
        //     if(k > nums.length - 1){
        //         return true;
        //     }
        // }

        if (nums == null) {
            return false;
        }
        // 前n-1个元素能够跳到的最远距离
        int k = 0;
        for (int i = 0; i <= k; i++) {
            //第i个元素能够跳到的最远距离
            int temp = i + nums[i];
            //更新最远距离
            k = Math.max(k, temp);
            //如果最远距离已经大于或等于最后一个元素的下标,则说明能跳过去,退出. 减少循环
            if (k >= nums.length - 1) {
                return true;
            }
        }
        //最远距离k不再改变,且没有到末尾元素
        return false;
    }

    /**
     * 跳跃游戏2
     * https://leetcode.cn/problems/jump-game-ii/?envType=study-plan-v2&envId=top-interview-150
     */


    public int jump1(int[] nums) {

        int length = nums.length;
        if(length == 0 || nums[0] == 0){
            return 0;
        }

        int count = 1;
        for (int i = 0; i < length; i++) {
            int max = i + nums[i];
            if(max >= length - 1){
                return 1;
            }
            for (int j = i + 1; j < max; j++) {
                max = j + nums[j];
                if (max < j + nums[j + 1]) {
                    max = j + nums[j + 1];
                }

                if (i + max >= length - 1) {
                    count++;
                    // System.out.println(count);
                    return count;
                }
            }
            i = i + max;
            count++;
        }
        return count;
    }

    @Test
    public void test11() {
        int arr[] = {1,2}; // 1
        // int arr[] = {2,3,1,1,4}; // 2
        // int arr[] = {1,1,1,1}; // 3
        // int arr[] = {3,4,3,2,5,4,3}; // 3
        // int arr[] = {1,2,1,1,1}; // 4
        System.out.println(jump(arr));
    }

    public int jump(int[] nums) {

        int length = nums.length;
        if(length == 0 || nums.length == 1 || nums[0] == 0){
            return 0;
        }
        int count = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i = index) {
            count++;
            int jump1 = i + nums[i];
            if(jump1 >= nums.length - 1){
                return count;
            }

            for (int j = i + 1; j < jump1 + 1; j++) {
                int jump2 = j + nums[j];
                if(max <= jump2){
                    max = jump2;
                    index = j;
                }

                if(max >= nums.length - 1){
                    count++;
                    return count;
                }
            }

            max = 0;

        }
        return count;
    }

    /**
     * https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
     * H指数
     */

    @Test
    public void test12() {
        // int arr[] = {3,0,6,1,5}; // 3
        // int arr[] = {1, 3, 1}; // 1
        int arr[] = {0, 1}; // 1
        System.out.println(hIndex(arr));
    }

    public int hIndex(int[] citations) {
        int h = citations.length;
        int count = 0;
        for (int i = 0; i < citations.length; i++) {
            for (int j = 0; j < citations.length; j++) {
                int temp = citations[j];
                if (h <= temp) {
                    count++;
                }
            }
            if (count >= h) {
                return h;
            } else {
                h--;
                count = 0;
            }

        }
        return h;
    }

    /**
     * 除自身以外数组的乘积
     * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test13() {
        int arr[] = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] output = new int[n];

        // 计算每个元素左侧元素的乘积
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // 计算每个元素右侧元素的乘积并与左侧元素的乘积相乘
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }






}
