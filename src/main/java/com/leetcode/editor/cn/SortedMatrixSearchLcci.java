package com.leetcode.editor.cn;

//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 双指针 二分查找 分治算法 
// 👍 27 👎 0


public class SortedMatrixSearchLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMatrixSearchLcci().new Solution();
        System.out.println(solution.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int length = matrix.length;
            if (length == 0) {
                return false;
            }
            int width = matrix[0].length;
            int i = length - 1;
            int j = 0;
            while (i >= 0 && i < length && j >= 0 && j < width) {
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