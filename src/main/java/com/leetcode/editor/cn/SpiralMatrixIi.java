package com.leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
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
// Related Topics 数组 矩阵 模拟 
// 👍 432 👎 0


public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        int[][] ans3 = solution.generateMatrix(3);
        int[][] ans4 = solution.generateMatrix(4);
        int[][] ans1 = solution.generateMatrix(1);

        System.out.println(ans1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ans = new int[n][n];
            int size = n * n;
            int top = 0;
            int down = n - 1;
            int left = 0;
            int right = n - 1;
            int index = 1;
            while (size > 0) {
                for (int i = left; i <= right && size>=0; i++) {
                    ans[top][i] = index;
                    index++;
                    size--;
                }
                top++;
                for (int i = top; i <= down && size>=0; i++) {
                    ans[i][right] = index;
                    index++;
                    size--;
                }
                right--;
                for (int i = right; i >= left && size>=0; i--) {
                    ans[down][i] = index;
                    index++;
                    size--;
                }
                down--;
                for (int i = down; i >= top && size>=0; i--) {
                    ans[i][left] = index;
                    index++;
                    size--;
                }
                left++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}