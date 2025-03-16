//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
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
//
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 1954 👎 0


package com.leetcode.editor.cn;

//Java：单词搜索
public class PWordSearch {
    public static void main(String[] args) {
        Solution solution = new PWordSearch().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] visited;

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean success = dfs(board, i, j, word, 0);
                    if (success) {
                        return true;
                    }
                }
            }
            return false;
        }


        private boolean dfs(char[][] board, int i, int j, String word, int index) {
            if (index >= word.length()) {
                return true;
            }
            int m = board.length;
            int n = board[0].length;
            if (i >= m || i < 0) {
                return false;
            }
            if (j >= n || j < 0) {
                return false;
            }
            if (visited[i][j]) {
                return false;
            }
            if (board[i][j] != word.charAt(index)) {
                return false;
            }
            visited[i][j] = true;
            boolean success = dfs(board, i, j + 1, word, index + 1);
            if (success) {
                return true;
            }
            success = dfs(board, i, j - 1, word, index + 1);
            if (success) {
                return true;
            }

            success = dfs(board, i + 1, j, word, index + 1);
            if (success) {
                return true;
            }
            success = dfs(board, i - 1, j, word, index + 1);
            if (success) {
                return true;
            }

            visited[i][j] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}