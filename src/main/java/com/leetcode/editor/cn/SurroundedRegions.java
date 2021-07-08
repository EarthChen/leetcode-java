package com.leetcode.editor.cn;

//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X"
//,"X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 560 👎 0


public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        // char[][] board = new char[][]{
        //         {'X', 'X', 'X', 'X'},
        //         {'X', 'O', 'O', 'X'},
        //         {'X', 'X', 'O', 'X'},
        //         {'X', 'O', 'X', 'O'},
        // };

        char[][] board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'},
        };
        solution.solve(board);

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 从边缘o开始搜索
                    boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                    if (isEdge && board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    }
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        public void dfs(char[][] board, int i, int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
                // board[i][j] == '#' 说明已经搜索过了.
                return;
            }
            board[i][j] = '#';
            dfs(board, i - 1, j); // 上
            dfs(board, i + 1, j); // 下
            dfs(board, i, j - 1); // 左
            dfs(board, i, j + 1); // 右
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}