package com.leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 862 👎 0


public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        System.out.println(solution.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        }, "ABCB"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (exists(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean exists(char[][] board, int i, int j, String word, int index) {
            if (i < 0 || i >= board.length) {
                return false;
            }
            if (j < 0 || j >= board[0].length) {
                return false;
            }
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            char t = board[i][j];
            board[i][j] = '0';
            boolean success =
                    exists(board, i - 1, j, word, index + 1) ||
                            exists(board, i + 1, j, word, index + 1) ||
                            exists(board, i, j - 1, word, index + 1) ||
                            exists(board, i, j + 1, word, index + 1);
            board[i][j] = t;
            return success;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}