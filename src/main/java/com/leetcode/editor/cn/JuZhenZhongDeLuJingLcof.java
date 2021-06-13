package com.leetcode.editor.cn;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 336 👎 0


public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(new char[][]{
                {'a'},
        }, "a"));
        System.out.println(solution.exist(new char[][]{
                {'a', 'a'},
        }, "aaa"));

        // System.out.println(solution.exist(new char[][]{
        //         {'A', 'B', 'C', 'E'},
        //         {'S', 'F', 'C', 'S'},
        //         {'A', 'D', 'E', 'E'}
        // }, "ABCCED"));
        //
        // System.out.println(solution.exist(new char[][]{
        //         {'a', 'b'},
        //         {'c', 'd'}
        // }, "abcd"));


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, int i, int j, String sb, int index) {
            if (index >= sb.length()) {
                return true;
            }
            if (i < 0 || i >= board.length) {
                return false;
            }
            if (j < 0 || j >= board[0].length) {
                return false;
            }
            if (sb.charAt(index) != board[i][j]) {
                return false;
            }
            char tmp = board[i][j];
            board[i][j] = '#';
            boolean success = dfs(board, i + 1, j, sb, index + 1) ||
                    dfs(board, i - 1, j, sb, index + 1) ||
                    dfs(board, i, j - 1, sb, index + 1) ||
                    dfs(board, i, j + 1, sb, index + 1);
            board[i][j] = tmp;
            return success;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}