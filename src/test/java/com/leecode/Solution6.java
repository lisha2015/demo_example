package com.leecode;

import org.junit.Test;

import java.util.Arrays;


/**
 * 分治
 */
public class Solution6 {


    class TreeNode {
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        int val;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 108. 将有序数组转换为二叉搜索树
     * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test01() {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    /**
     * 排序链表
     * https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-interview-150
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test02() {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        for (int i = 0; i < 10; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode listNode = sortList(head.next);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * 建立四叉树
     * https://leetcode.cn/problems/construct-quad-tree/description/?envType=study-plan-v2&envId=top-interview-150
     */
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
        }
    }

    @Test
    public void test03() {
        int[][] grid = new int[][]{{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        Node node = construct(grid);
        System.out.println(node);
    }

    public Node construct(int[][] grid) {
        return dfs(grid, 0, 0, grid.length);
    }

    public Node dfs(int[][] grid, int x, int y, int n) {
        if (n == 1) {
            return new Node(grid[x][y] == 1, true);
        }
        Node node = new Node();
        node.topLeft = dfs(grid, x, y, n / 2);
        node.topRight = dfs(grid, x, y + n / 2, n / 2);
        node.bottomLeft = dfs(grid, x + n / 2, y, n / 2);
        node.bottomRight = dfs(grid, x + n / 2, y + n / 2, n / 2);
        if (node.topLeft.val == node.topRight.val && node.topRight.val == node.bottomLeft.val && node.bottomLeft.val == node.bottomRight.val && node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf) {
            node.val = node.topLeft.val;
            node.isLeaf = true;
            node.topLeft = null;
            node.topRight = null;
            node.bottomLeft = null;
            node.bottomRight = null;
        }

        return node;
    }

    /**
     * 合并k个有序链表
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test04() {
        ListNode[] lists = new ListNode[]{new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6))};
        ListNode listNode = mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 最大子数组和
     * https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test05() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
            if (nums[i] < 0) {
                nums[i] = 0;
            }
            // System.out.println(Arrays.toString(nums));
        }

        return max;

    }

    /**
     * 环形子数组的最大和
     * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
     * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
     * https://leetcode.cn/problems/maximum-sum-circular-subarray/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test06() {
        int[] nums = new int[]{-2, -3, -1};
        int i = maxSubarraySumCircular(nums);
        System.out.println(i);
    }

    /**
     * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
     * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
     * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = kadane(nums);

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = -nums[i];
        }

        int minSum = kadane(nums) + totalSum;

        return minSum == 0 ? maxSum : Math.max(maxSum, minSum);
    }

    private int kadane(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    /**
     * 搜索插入位置
     * https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test07() {
        int[] nums = new int[]{1, 3, 6, 7};
        int target = 5;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
       return left;
   }

    /**
     * 搜索二维矩阵
     * https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test08() {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] < target) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 寻找峰值
     * https://leetcode.cn/problems/find-peak-element/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test09() {
        int[] nums = new int[]{1, 2, 3, 1};
        int i = findPeakElement(nums);
        System.out.println(i);
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 搜索旋转排序数组
     * https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test10() {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int i = search(nums, target);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test11() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                ans[1] = mid;
                while (ans[0] > 0 && nums[ans[0] - 1] == target) {
                    ans[0]--;
                }
                while (ans[1] < nums.length - 1 && nums[ans[1] + 1] == target) {
                    ans[1]++;
                }
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }









}
