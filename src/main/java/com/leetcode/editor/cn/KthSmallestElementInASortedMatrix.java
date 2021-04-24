package com.leetcode.editor.cn;

//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= 109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 堆 二分查找 
// 👍 575 👎 0


public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // System.out.println(solution.kthSmallest(new int[][]{
        //         {1, 5, 9},
        //         {10, 11, 13},
        //         {12, 13, 15}
        // }, 8));
        // System.out.println(solution.kthSmallest(new int[][]{
        //         {-5},
        // }, 1));
        System.out.println(solution.kthSmallest(new int[][]{
                {1, 2},
                {1, 3}
        }, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;
            int left = matrix[0][0];
            int right = matrix[row - 1][col - 1];
            while (left < right) {
                // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
                int mid = left + (right - left) / 2;
                // 找二维矩阵中<=mid的元素总个数
                int count = findNotBiggerThanMid(matrix, mid, row, col);
                if (count < k) {
                    // 第k小的数在右半部分，且不包含mid
                    left = mid + 1;
                } else {
                    // 第k小的数在左半部分，可能包含mid
                    right = mid;
                }
            }
            return right;
        }

        private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
            // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
            int i = row - 1;
            int j = 0;
            int count = 0;
            while (i >= 0 && j < col) {
                if (matrix[i][j] <= mid) {
                    // 第j列有i+1个元素<=mid
                    count += i + 1;
                    j++;
                } else {
                    // 第j列目前的数大于mid，需要继续在当前列往上找
                    i--;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}