package com.leecode;

import org.junit.Test;

import java.util.*;

public class Solution5 {

    /**
     * 二进制求和
     * https://leetcode.cn/problems/add-binary/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test01() {
        String a = "11", b = "1";
        System.out.println(addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();
    }


    /**
     * 颠倒二进制位
     * https://leetcode.cn/problems/reverse-bits/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test02() {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }

    /**
     * 位1的个数
     * https://leetcode.cn/problems/number-of-1-bits/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test03() {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    private int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        if (res != 0) return res;
        if (n == 0) return 0;
        return res;
    }

    /**
     * 只出现一次的数字
     * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test04() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    /**
     * 判断nums中只出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    /**
     * 只出现一次的数字 II
     * https://leetcode.cn/problems/single-number-ii/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test05() {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber2(nums));
    }

    /**
     * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
     * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= bits[31 - i] % 3;
        }
        return res;
    }

    /**
     * 数字范围按位与
     * https://leetcode.cn/problems/bitwise-and-of-numbers-range/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test06() {
        int left = 5, right = 7;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    /**
     * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
     *
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }

    /**
     * 回文数
     * https://leetcode.cn/problems/bitwise-and-of-numbers-range/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test07() {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    /**
     * 加1
     * https://leetcode.cn/problems/plus-one/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test08() {
        int[] digits = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    /**
     * 阶乘后的0
     * https://leetcode.cn/problems/factorial-trailing-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test09() {
        int n = 3;
        System.out.println(trailingZeroes(n));
    }

    /**
     * 给定一个整数 n ，返回 n阶乘结果中尾随零的数量。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    /**
     * x的平方根
     * https://leetcode.cn/problems/sqrtx/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test10() {
        int x = 8;
        System.out.println(mySqrt(x));
    }

    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Pow(x,n)
     * https://leetcode.cn/problems/powx-n/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test11() {
        double x = 2.00000;
        int n = -2;
        System.out.println(myPow(x, n));
    }

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double current_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * current_product;
            }
            current_product = current_product * current_product;
        }
        return ans;
    }

    /**
     * 直线上最多的点数
     * https://leetcode.cn/problems/max-points-on-a-line/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test12() {
        int[][] points = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(maxPoints(points));
    }

    /**
     * 给你一个数组 points, 其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int n = points.length;
        if (n <= 2) {
            return n;
        }

        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                String slope = (dx / gcd) + "#" + (dy / gcd);

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;

    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 爬楼梯
     * https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test13() {
        int n = 2;
        System.out.println(climbStairs(n));
    }
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test14() {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 单词拆分
     * https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test15() {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i - len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

    /**
     * 零钱兑换
     * https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test16() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                }
            }
            if (dp[n][amount] == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return dp[n][amount];
    }

    /**
     * 最长递增子序列
     * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test17() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * 组合
     * https://leetcode.cn/problems/combinations/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test18() {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 全排列
     * https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test19() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path, used, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, used, res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /**
     * 组合总和
     * https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test20() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }

    /**
     * N皇后
     * https://leetcode.cn/problems/n-queens-ii/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test21() {
        int n = 4;
        System.out.println(totalNQueens(n));
    }

    public int totalNQueens(int n) {
        int[] cols = new int[n];
        int[] diag1 = new int[2 * n - 1];
        int[] diag2 = new int[2 * n - 1];
        return dfs(n, 0, cols, diag1, diag2);
    }

    private int dfs(int n, int row, int[] cols, int[] diag1, int[] diag2) {
        if (row == n) {
            return 1;
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            if (cols[col] == 1 || diag1[row + col] == 1 || diag2[row - col + n - 1] == 1) {
                continue;
            }
            cols[col] = 1;
            diag1[row + col] = 1;
            diag2[row - col + n - 1] = 1;
            res += dfs(n, row + 1, cols, diag1, diag2);
            cols[col] = 0;
            diag1[row + col] = 0;
            diag2[row - col + n - 1] = 0;
        }
        return res;
    }

    /**
     * 括号生成
     * https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test22() {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, n, "", res);
        return res;
    }

    private void dfs(int left, int right, String path, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, path + "(", res);
        }
        if (right > left) {
            dfs(left, right - 1, path + ")", res);
        }
    }

    /**
     * 单词搜索
     * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test23() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if (dfs(board, word, index + 1, i - 1, j, visited)
                || dfs(board, word, index + 1, i + 1, j, visited)
                || dfs(board, word, index + 1, i, j - 1, visited)
                || dfs(board, word, index + 1, i, j + 1, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }




}
