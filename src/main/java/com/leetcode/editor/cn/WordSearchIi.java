package com.leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 
// 👍 406 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();

        System.out.println(solution.findWords(new char[][]{
                {'a', 'a'},
        }, new String[]{"aaa"}));

        System.out.println(solution.findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath", "pea", "eat", "rain"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Set<String> ans = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            Map<Character, List<String>> map = new HashMap<>();
            for (String word : words) {
                char firstChar = word.charAt(0);
                List<String> list = map.getOrDefault(firstChar, new ArrayList<>());
                list.add(word);
                map.put(firstChar, list);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    List<String> wordList = map.getOrDefault(board[i][j], new ArrayList<>());
                    for (String s : wordList) {
                        dfs(board, i, j, 0, s);
                    }
                }
            }
            return new ArrayList<>(ans);
        }

        private void dfs(char[][] board, int i, int j, int index, String word) {
            if (i < 0 || i >= board.length) {
                return;
            }
            if (j < 0 || j >= board[0].length) {
                return;
            }
            if (index >= word.length()) {
                return;
            }
            char curChar = board[i][j];
            if (curChar != word.charAt(index)) {
                return;
            }
            if (index == word.length() - 1) {
                ans.add(word);
                return;
            }
            board[i][j] = '#';
            dfs(board, i - 1, j, index + 1, word);
            dfs(board, i + 1, j, index + 1, word);
            dfs(board, i, j - 1, index + 1, word);
            dfs(board, i, j + 1, index + 1, word);
            board[i][j] = curChar;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}