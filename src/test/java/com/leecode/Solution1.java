package com.leecode;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;

public class Solution1 {
    @Test
    public void test1() {
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


    /**
     * 接雨水-双指针算法
     * https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test2() {
        int arr[] = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr));
    }

    public int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }


        return result;

    }

    /**
     * 分发糖果
     * https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test3() {
        int arr[] = {1, 0, 2};
        System.out.println(candy(arr));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // 每个孩子先分1颗糖
        Arrays.fill(candies, 1);
        // 从左往右遍历，保证右边比左边评分高的孩子糖果数更多
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右往左遍历，保证左边比右边评分高的孩子糖果数更多
        for (int i = n - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ratings[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总共需要的糖果数
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }

        return total;

    }

    /**
     * 最大正方形
     * https://leetcode.cn/problems/maximal-square/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test4() {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        // char[][] arr = {{'0', '1'}};
        System.out.println(maximalSquare(arr));
    }

    public int maximalSquare(char[][] matrix) {

        int start[] = new int[2];
        int end[] = new int[2];
        int square = 0;
        for (int i = 0; i < matrix.length; i++) {
            char[] temp = matrix[0];
            start[0] = -1;
            end[0] = -1;
            int tempSquare = 0;
            for (int j = 0; j < matrix[i].length; j++) {

                if(start[0] == -1 && matrix[i][j] == '0'){
                    continue;
                }

                if(matrix[i][j] == '1'){
                    if(start[0] == -1){
                        start[0] = i;
                        start[1] = j;
                    }
                    if(j == matrix[i].length - 1 && end[0] == -1){
                        end[0] = i;
                        end[1] = matrix[i].length - 1;
                    }
                } else{
                    if(end[0] == -1){
                        end[0] = i;
                        end[1] = j - 1;
                    }
                }

                if(end[0] != -1 && start[0] != -1){
                    if(j - 1 == start[1]){
                        tempSquare = 1;
                    } else {
                        tempSquare = (j - start[1] + 1) * (j - start[1] + 1);
                    }


                    int size = end[1] - start[1] + 1;
                    if(size == 0){
                        size = 1;
                    }
                    boolean shouldBreak = false;
                    if(size > 1){
                        if(i + size <= matrix.length){
                            for (int i1 = i; i1 < i + size ; i1++) {
                                for (int k = start[1]; k < end[1] + 1 ; k++) {
                                    if(matrix[i1][k] == '0'){
                                        shouldBreak = true;
                                        break;
                                    }
                                }
                                if(shouldBreak){
                                    break;
                                }
                            }
                        } else {
                            shouldBreak = true;
                        }

                    }
                    if(!shouldBreak){
                        square = Math.max(square, tempSquare);
                    }

                    start[0] = -1;
                    end[0] = -1;

                }

            }
        }

        return square;
    }

    @Test
    public void test5() {
        int n = 11;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            boolean flag = (i % 2 == 0) ? true : false;
            if(!flag){
                continue;
            }
            for (int j = 0; j < n; j++) {
                int half = i / 2;
                if(j >= mid - half && j<= mid + half){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    /**
     * 文本左右对齐
     * https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test6() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;

        while (start < words.length) {
            int end = findEndIndex(words, start, maxWidth);
            result.add(justifyLine(words, start, end, maxWidth));
            start = end + 1;
        }

        return result;
    }

    private int findEndIndex(String[] words, int start, int maxWidth) {
        int end = start;
        int totalLength = 0;

        while (end < words.length && totalLength + words[end].length() + end - start <= maxWidth) {
            totalLength += words[end].length();
            end++;
        }

        return end - 1;
    }

    private String justifyLine(String[] words, int start, int end, int maxWidth) {
        if (end == start || end == words.length - 1) {
            return leftJustify(words, start, end, maxWidth);
        } else {
            return middleJustify(words, start, end, maxWidth);
        }
    }

    private String leftJustify(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i < end) {
                sb.append(" ");
            }
        }

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }

    private String middleJustify(String[] words, int start, int end, int maxWidth) {
        int wordLength = 0;

        for (int i = start; i <= end; i++) {
            wordLength += words[i].length();
        }

        int spaces = maxWidth - wordLength;
        int slots = end - start;
        int avgSpaces = spaces / slots;
        int extraSpaces = spaces % slots;

        StringBuilder sb = new StringBuilder();

        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i < end) {
                for (int j = 0; j < avgSpaces + (i - start < extraSpaces ? 1 : 0); j++) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }

    /**
     * 找出字符串中第一个匹配项的下标
     * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test7() {
        // String haystack = "sadbutsad", needle = "sad";
        // String haystack = "leetcode", needle = "leeto";
        // String haystack = "mississippi", needle = "issip";
        String haystack = "aaa", needle = "aaaa";
        System.out.println(strStr(haystack, needle));
    }


    public int strStr(String haystack, String needle) {

        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        int count = 0;
        for (int i = 0; i < haystackCharArray.length; i++) {

            if (haystackCharArray[i] == needleCharArray[count]) {
                if (i + needle.length() > haystackCharArray.length) {
                    break;
                }
                int minLength = Math.min(haystackCharArray.length, i + needle.length());
                for (int j = i + 1; j < minLength; j++) {
                    if (haystackCharArray[j] == needleCharArray[count + 1]) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
                if (count == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;

    }

    /**
     * 改进版本
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {

        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(count)) {
                if (i + needle.length() > haystack.length()) {
                    break;
                }
                int minLength = Math.min(haystack.length(), i + needle.length());
                for (int j = i + 1; j < minLength; j++) {
                    if (haystack.charAt(j) == needle.charAt(count + 1)) {
                        count++;
                    } else {
                        count = 0;
                        break;
                    }
                }
                if (count == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;

    }

    /**
     * 最长公共前缀
     * https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test8() {
        // String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"aa", "ab"};
        System.out.println(longestCommonPrefix2(strs));
    }

    public String longestCommonPrefix2(String[] strs) {

        List<Integer> indexList = new ArrayList<>(10);
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length() <= min){
                min = strs[i].length();
            }
        }

        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() == min){
                indexList.add(i);
            }
        }

        Set<String> wordSet = new HashSet<>(10);
        for (int i = 0; i < indexList.size(); i++) {
            wordSet.addAll(mix(strs[indexList.get(i)]));
        }

        String commonStr = "";
        Boolean flag = true;
        wordSet.stream().sorted();
        for (String item : wordSet) {
            for (int i = 0; i < strs.length; i++) {
                if(!strs[i].startsWith(item)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(commonStr.length() < item.length()){
                    commonStr = item;
                    System.out.println(item);
                }
            }
            flag = true;

        }


        return commonStr;
    }

    /**
     * 遍历了一个单词所用从0开始到length长度之间的从左到右顺序组合
     * @param word
     * @return
     */
    public Set<String> mix1(String word){
        Set<String> wordArray = new LinkedHashSet<>(10);
        int  index = 0, length = word.length();

        for (int k = 1; k <= length; k++) {
            while (k + index <= length) {
                wordArray.add(word.substring(index, k + index));
                index++;
            }
            index = 0;
        }
        return wordArray;
    }

    /**
     * 必须带有前缀
     * @param word
     * @return
     */
    public Set<String> mix2(String word){
        Set<String> wordArray = new LinkedHashSet<>(10);
        if(word.length() <= 2){
            wordArray.add(word);
            return wordArray;
        }
        int  length = word.length();

        for (int k = 1; k <= length; k++) {
            wordArray.add(word.substring(0, k));
        }
        return wordArray;
    }

    @Test
    public void test10(){
        System.out.println((mix1("ABCDE")));
    }


    /**
     * 最长公共前缀-重做
     * https://leetcode.cn/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test11() {
        // String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"aa", "ab"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String commonStr = "";
        boolean flag = true;
        int length = strs[0].length();

        for (int i = 1; i <= length; i++) {
            String temp = strs[0].substring(0, i);
            for (int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(temp)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(commonStr.length() < temp.length()){
                    commonStr = temp;
                    System.out.println(commonStr);
                }
            }
            flag = true;

        }
        return commonStr;
    }

    /**
     * 必须带有前缀
     * @param word
     * @return
     */
    public Set<String> mix(String word){
        Set<String> wordArray = new LinkedHashSet<>(10);
        int  length = word.length();
        for (int k = 1; k <= length; k++) {
            wordArray.add(word.substring(0, k));
        }
        return wordArray;
    }

    @Test
    public void test12(){
        System.out.println((mix1("ABCDE")));
    }





}





