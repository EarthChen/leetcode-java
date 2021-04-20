package com.leetcode.editor.cn;

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrixrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：matrixrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrixrix.length 
// n == matrixrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrixrix[i][j] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 475 👎 0


import java.util.Arrays;

public class SetmatrixrixZeroes {
    public static void main(String[] args) {
        Solution solution = new SetmatrixrixZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            // 1. 扫描「首行」和「首列」记录「首行」和「首列」是否该被置零
            boolean r0 = false, c0 = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    r0 = true;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    c0 = true;
                    break;
                }
            }

            // 2.1 扫描「非首行首列」的位置，如果发现零，将需要置零的信息存储到该行的「最左方」和「最上方」的格子内
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，进行「非首行首列」置零
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0) {
                    for (int i = 1; i < m; i++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                if (matrix[i][0] == 0) {
                    Arrays.fill(matrix[i], 0);
                }
            }

            // 3. 根据最开始记录的「首行」和「首列」信息，进行「首行首列」置零
            if (r0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (c0) {
                Arrays.fill(matrix[0], 0);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}