//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 分治 矩阵 👍 1159 👎 0


package com.leetcode.editor.cn;

//Java：搜索二维矩阵 II
public class P240SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P240SearchA2dMatrixIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int len = matrix.length;
            int width = matrix[0].length;
            int i = len - 1;
            int j = 0;
            while (i >= 0 && j < width) {
                int num = matrix[i][j];
                if (num == target) {
                    return true;
                }
                if (num > target) {
                    i--;
                } else {
                    j++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}