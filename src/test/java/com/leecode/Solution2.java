package com.leecode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class Solution2 {

    /**
     * 最小覆盖串
     * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test01(){

        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));

    }

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // 初始化目标字符的出现次数
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = targetMap.size();
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        // 滑动窗口算法
        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                targetMap.put(c, targetMap.get(c) - 1);
                if (targetMap.get(c) == 0) {
                    count--;
                }
            }

            // 移动左指针缩小窗口
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }

            right++;
        }

        // 返回最小子串或空字符串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    /**
     * 最后一个单词的长度
     * https://leetcode.cn/problems/length-of-last-word/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test02(){

        // String s = "   fly me   to   the moon  ";
        String s = "a";
        System.out.println(lengthOfLastWord(s));
        System.out.println();

    }

    public int lengthOfLastWord(String s) {

        /**
         *  s = s.trim();
         *         s = s.replace("  ", " ");
         *         String[] s1 = s.split(" ");
         *         String temp = s1[s1.length - 1];
         *         return temp.length();
         */
        s = s.trim();
        char[] charArray = s.toCharArray();
        int length = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(charArray[i] != 32){
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    /**
     * 反转字符串中的单词
     * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test03(){
        String s = "a good   example";
        System.out.println(reverseWords(s));
        System.out.println();

    }

    public String reverseWords(String s) {
        s.trim();
        s = s.replace("  ", " ");
        StringBuilder result = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            result.append(c);
        }
        return result.toString();
    }

    /**
     * 验证回文子串
     * https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
     */


    @Test
    public void test04(){
        // String s = "A man, a plan, a canal: Panama";
        String s = "0P";
        System.out.println(isPalindrome(s));
        System.out.println();
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        s1 = s1.replaceAll("\\s", "");
        char[] charArray = s1.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left <= right){
            if(charArray[left] == charArray[right]){
                left++;
                right--;
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

    /**
     * 判断子序列
     * https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test05(){
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println();
    }

    public boolean isSubsequence(String s, String t) {
        int left1 = 0, left2 = 0;

        if(s.length() == 0 || t.length() == 0){
            return false;
        }

        if(s.length() > t.length()){
            return false;
        }
        while (left2 < t.length()){

            if(s.charAt(left1) == t.charAt(left2)){
                left1++;
            }
            if(left1 == s.length()){
                return true;
            }
            left2++;

        }

        return false;
    }

    /**
     * 两数之和2 输入有序数组
     * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test06(){
        // int[] numbers = {2,7,11,15};
        int[] numbers = {5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left1 = 0;
        int left2 = numbers.length - 1;
        while (left1 < numbers.length){
            int total = numbers[left1] + numbers[left2] ;
            if(total < target){
                left1++;
            } else if (total > target) {
                left2--;
            } else {
                return new int[]{left1 + 1, left2 + 1};
            }
        }

        return null;

    }

    /**
     * 三数之和
     * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test07(){
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        // int[] numbers = {0, 0, 0};
        // threeSum(numbers).forEach(System.out::println);
        threeSum1(numbers).forEach(System.out::println);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(10);
        int i = 0, j = 1, k = 2;
        while (i < nums.length - 2) {
            List<Integer> list = new ArrayList<>(3);
            int total = nums[i] + nums[j] + nums[k];
            if (total == 0) {
                list.add(nums[i]);
                list.add(nums[j]);
                list.add(nums[k]);
                result.add(list);
                k++;
                if (k == nums.length) {
                    return result;
                }
            } else {
                k++;
                if (k == nums.length) {
                    j++;
                    k = j + 1;
                    if (j == nums.length - 1) {
                        i++;
                        j = i + 1;
                        k = j + 1;
                        if (k == nums.length) {
                            return result;
                        }
                    }
                }
            }

        }
        return null;
    }


    public List<List<Integer>> threeSum1(int[] nums) {

        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(numsList);


        List<List<Integer>> result = new ArrayList<>(10);
        int i = 0, j = 1, k = 2;
        while (i < numsList.size() - 2) {
            List<Integer> list = new ArrayList<>(3);
            int total = numsList.get(i) + numsList.get(j) + numsList.get(k);
            if (total == 0) {
                list.add(numsList.get(i));
                list.add(numsList.get(j));
                list.add(numsList.get(k));
                result.add(list);
                k++;
                if (k == nums.length) {
                    return result;
                }
            } else {
                k++;
                if (k == nums.length) {
                    j++;
                    k = j + 1;
                    if (j == nums.length - 1) {
                        i++;
                        j = i + 1;
                        k = j + 1;
                        if (k == nums.length) {
                            return result;
                        }
                    }
                }
            }

        }
        return null;
    }


    /**
     * 长度最小的子数组
     * https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test08() {
        // int[] numbers = {2, 3, 1, 2, 4, 3};
        // int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1};
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 11;
        System.out.println(minSubArrayLen(target, numbers));
    }

    /**
     * 未实现-有bug
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int length = end - start + 1;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            count += temp;
            while (count >= target){
                flag = true;
                end = i;
                int tempLength = end - start + 1;
                if(length > tempLength){
                    length = tempLength;
                }
                count = count - nums[start];
                start++;
                if(count >= target){
                    length--;
                }
            }
        }
        return flag ? length : 0;

    }

    public int minSubArrayLen2(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (end < nums.length){
            sum += nums[end++];
            while (sum >= target){
                min = Integer.min(min, end - start);
                sum -= nums[start++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if(temp >= target){
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if(temp>=target){
                    min = Integer.min(min, j - i + 1);
                    break;
                }
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 无重复字符的最长子串
     * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test09() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }


    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        List<Character> list = new ArrayList<>();

        while (start < s.length()){
            char c = s.charAt(end++);
            if (list.contains(c)) {
                while (list.contains(c)){
                    list.remove(0);
                }
                list.add(c);
            } else {
                list.add(c);
                max = Integer.max(max, list.size());
            }
            start++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }


    /**
     * 盛水最多的容器
     * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test10() {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] arr = {1, 1};
        System.out.println(maxArea(arr));
    }

    public int maxArea(int[] height) {

        if(height.length < 2){
            return 0;
        }
        int left = 0, right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int high = Integer.min(height[left], height[right]);
            int tempSum = (right - left) * high;
            sum = Integer.max(sum, tempSum);
            if(height[left] > height[right]){
                right--;
            } else {
                left++;
            }
        }
        return sum;
    }


    /**
     * 串联所有单词的子串
     * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test11() {
        // String[] arr = {"foo", "bar"};
        // String s = "foobarfoobar";
        String[] arr = {"a", "a"};
        String s = "aaa";
        findSubstring(s, arr).forEach(System.out::println);
    }

    /**
     * 暴力解法-空间溢出
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        List<List<String>> permuteList = permuteUnique(words);
        for (int i = 0; i < permuteList.size(); i++) {
            StringBuilder sb = new StringBuilder();
            permuteList.get(i).forEach(item->{
                sb.append(item);
            });

            int index = s.indexOf(sb.toString());
            int k = 0;
            while (index != -1){
                if(!result.contains(index)){
                    result.add(index);
                }
                k++;
                if(k <= s.length() - sb.toString().length()){
                    String substring = s.substring(k, s.length());
                    index = substring.indexOf(sb.toString());
                    if(index == -1){
                        break;
                    } else {
                        index = index + k;
                    }
                } else {
                    break;
                }
            }

        }
        // arr的所有排列组合
        return result;
    }


    public List<List<String>> permuteUnique(String[] nums) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, tempList, nums, used);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i].equals(nums[i - 1]) && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    @Test
    public void main() {
        String[] nums = {"word","good","best","good"};
        List<List<String>> result = permuteUnique(nums);
        System.out.println(result);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordNum = words.length;
        int totalLen = wordLen * wordNum;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < wordNum) {
                String sub = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (wordCount.containsKey(sub)) {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    if (seen.get(sub) > wordCount.get(sub)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == wordNum) {
                result.add(i);
            }
        }

        return result;
    }








}



