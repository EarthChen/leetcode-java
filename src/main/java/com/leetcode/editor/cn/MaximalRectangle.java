package com.leetcode.editor.cn;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 963 👎 0


public class MaximalRectangle {
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        System.out.println(solution.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int length = matrix.length;
            if (length == 0) {
                return 0;
            }
            int width = matrix[0].length;
            int[][] dp = new int[length][width];
            int max = 0;
            for (int i = 0; i < length; i++) {
                dp[i][0] = matrix[i][0] - '0';
            }
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    char cur = matrix[i][j];
                    if (cur == '0') {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (j != 0) {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                    int row = 1;
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k >= 0; k--) {
                        min = Math.min(min, dp[k][j]);
                        max = Math.max(max, min * row);
                        row++;
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}