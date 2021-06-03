package com.leetcode.editor.cn;

//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组 
// 👍 31 👎 0


public class ZeroMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new ZeroMatrixLcci().new Solution();
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);

        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void setZeroes(int[][] matrix) {
            int length = matrix.length;
            int width = matrix[0].length;
            boolean firstCol = false;
            boolean firstRow = false;
            for (int i = 0; i < length; i++) {
                if (matrix[i][0] == 0) {
                    firstRow = true;
                    break;
                }
            }
            for (int i = 0; i < width; i++) {
                if (matrix[0][i] == 0) {
                    firstCol = true;
                    break;
                }
            }
            for (int i = 1; i < length; i++) {
                for (int j = 1; j < width; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < width; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 1; i < width; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            if (firstRow) {
                for (int i = 0; i < length; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (firstCol) {
                for (int i = 0; i < width; i++) {
                    matrix[0][i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}