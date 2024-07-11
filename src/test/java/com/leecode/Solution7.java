package com.leecode;

import org.junit.Test;

import java.util.*;

public class Solution7 {

    /**
     * Z字形变换
     * https://leetcode.cn/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test01(){
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < len; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < len) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 字母异位词分组
     * https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test02(){
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 两数之和
     * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test03(){
        int arr[] = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        // 时间复杂度小于O(n^2)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if(map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            }
            map.put(nums[i], i);
        }
        return nums;

    }

    /**
     * 快乐数
     * https://leetcode.cn/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
     */













}
