//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 903 👎 0


package com.leetcode.editor.cn;

//Java：螺旋矩阵 II
public class P59SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int count = n * n;
            int[][] matrix = new int[n][n];
            int l = 0;
            int r = n - 1;
            int top = 0;
            int down = n - 1;
            int index = 1;
            while (index <= count) {
                for (int i = l; i <= r && index <= count; i++) {
                    matrix[top][i] = index;
                    index++;
                }
                top++;
                for (int i = top; i <= down && index <= count; i++) {
                    matrix[i][r] = index;
                    index++;
                }
                r--;
                for (int i = r; i >= l && index <= count; i--) {
                    matrix[down][i] = index;
                    index++;
                }
                down--;
                for (int i = down; i >= top && index <= count; i--) {
                    matrix[i][l] = index;
                    index++;
                }
                l++;
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}