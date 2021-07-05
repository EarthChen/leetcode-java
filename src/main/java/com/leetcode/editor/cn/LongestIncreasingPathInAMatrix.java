package com.leetcode.editor.cn;

//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 231 - 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 
// 👍 487 👎 0


public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingPathInAMatrix().new Solution();
        System.out.println(solution.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        }));

        // System.out.println(solution.longestIncreasingPath(new int[][]{
        //         {3, 4, 5},
        //         {3, 2, 6},
        //         {2, 2, 1},
        // }));

        // System.out.println(solution.longestIncreasingPath(new int[][]{
        //         {3, 1},
        // }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int max = 0;

        public int longestIncreasingPath(int[][] matrix) {
            int length = matrix.length;
            int width = matrix[0].length;
            int[][] dp = new int[length][width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (dp[i][j] == 0) {
                        dfs(matrix, dp, i, j, -1);
                    }
                }
            }
            return max;
        }

        private int dfs(int[][] matrix, int[][] dp, int i, int j, int val) {
            if (i < 0 || i >= matrix.length) {
                return 0;
            }
            if (j < 0 || j >= matrix[0].length) {
                return 0;
            }
            boolean flag = val == -1;
            if (!flag) {
                if (matrix[i][j] >= val) {
                    return 0;
                }
            }

            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            int top = dfs(matrix, dp, i - 1, j, matrix[i][j]);
            int down = dfs(matrix, dp, i + 1, j, matrix[i][j]);
            int left = dfs(matrix, dp, i, j - 1, matrix[i][j]);
            int right = dfs(matrix, dp, i, j + 1, matrix[i][j]);

            dp[i][j] = 1 + Math.max(Math.max(Math.max(top, left), down), right);
            max = Math.max(max, dp[i][j]);
            return dp[i][j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}