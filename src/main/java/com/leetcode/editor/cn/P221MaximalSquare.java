//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1307 👎 0


package com.leetcode.editor.cn;

//Java：最大正方形
public class P221MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {

            int len = matrix.length;
            int width = matrix[0].length;
            int[][] dp = new int[len + 1][width + 1];
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                        max = Math.max(dp[i + 1][j + 1], max);
                    }
                }
            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}