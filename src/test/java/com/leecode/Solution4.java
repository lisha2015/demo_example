package com.leecode;

import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Solution4 {

    /**
     * 图-岛屿的数量
     * https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test01(){

    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }


    /**
     * 克隆图
     * https://leetcode.cn/problems/clone-graph/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test02(){

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node[] visited = new Node[101];
        return dfs(node, visited);
    }

    private Node dfs(Node node, Node[] visited) {
        if (visited[node.val] != null) {
            return visited[node.val];
        }
        if (node != null) {
            visited[node.val] = new Node(node.val);
            for (Node neighbor : node.neighbors) {
                visited[node.val].neighbors.add(dfs(neighbor, visited));
            }
            return visited[node.val];
        }
        if (node == null) {
            return null;
        }
        return null;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 图的广度优先算法
     * 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
     * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
     * 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
     * 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n2)] 。
     * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
     * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
     * 当玩家到达编号 n2 的方格时，游戏结束。
     * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n2 的方格上没有蛇或梯子。
     * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
     * https://leetcode.cn/problems/snakes-and-ladders/?envType=study-plan-v2&envId=top-interview-150
     */

    @Test
    public void test03(){

    }

    /**
     * 蛇梯棋
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] cells = new int[n * n + 1];
        int label = 1;
        for (int r = n - 1; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == -1) {
                    cells[label] = label;
                } else {
                    cells[label] = board[r][c];
                }
                label++;
            }
        }
        int[] dist = new int[n * n + 1];
        for (int label1 = 1; label1 < dist.length; label1++) {
            dist[label1] = -1;
        }
        dist[1] = 0;
        for (int label2 = 1; label2 < dist.length; label2++) {
            for (int next = label2 + 1; next <= label2 + 6 && next < dist.length; next++) {
                if (dist[next] == -1) {
                    dist[next] = dist[label2] + 1;
                    if (next == dist.length - 1) {
                        return dist[next];
                    }
                }
            }
        }

        return dist[dist.length - 1];
    }

    /**
     * 单词接龙
     * https://leetcode.cn/problems/word-ladder/description/?envType=study-plan-v2&envId=top-interview-150
     * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
     *
     * 每一对相邻的单词只差一个字母。
     *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
     * sk == endWord
     * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
     */
    @Test
    public void test04(){

    }

    /**
     * 请实现单词接龙算法
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(endWord)) {
                    return level;
                }

                char[] charArray = currentWord.toCharArray();

                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }

                        charArray[j] = c;
                        String newWord = new String(charArray);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }

                    charArray[j] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }

    /**
     * 单词搜索二
     * https://leetcode.cn/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     */

    public void test05()
    {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        Solution3 solution3 = new Solution3();
        // List<String> list = solution3.findWords(board,words);
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
     * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // 避免重复添加单词
        }

        board[i][j] = '#'; // 标记访问过的位置
        if (i > 0) dfs(board, i - 1, j, node, result);
        if (j > 0) dfs(board, i, j - 1, node, result);
        if (i < board.length - 1) dfs(board, i + 1, j, node, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, node, result);
        board[i][j] = c; // 恢复原字符
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
    }

    /**
     * 电话号码的字母组合
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
     */
    @Test
    public void test06()
    {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        String[] letters = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs1(combinations, letters, new StringBuilder(), 0, digits);
        return combinations;
    }

    private void dfs1(List<String> combinations, String[] letters, StringBuilder stringBuilder, int i, String digits) {
        if (i == digits.length()) {
            combinations.add(stringBuilder.toString());
            return;
        }

        String letter = letters[digits.charAt(i) - '0'];
        for (int j = 0; j < letter.length(); j++) {
            stringBuilder.append(letter.charAt(j));
            dfs1(combinations, letters, stringBuilder, i + 1, digits);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    /**
     * 异位字符串
     * https://leetcode.cn/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
     *
     */
    @Test
    public void test07()
    {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }


}
