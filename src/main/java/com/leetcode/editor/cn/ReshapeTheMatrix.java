package com.leetcode.editor.cn;

//在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。 
//
// 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。 
//
// 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。 
//
// 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。 
//
// 示例 1: 
//
// 
//输入: 
//nums = 
//[[1,2],
// [3,4]]
//r = 1, c = 4
//输出: 
//[[1,2,3,4]]
//解释:
//行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
// 
//
// 示例 2: 
//
// 
//输入: 
//nums = 
//[[1,2],
// [3,4]]
//r = 2, c = 4
//输出: 
//[[1,2],
// [3,4]]
//解释:
//没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
// 
//
// 注意： 
//
// 
// 给定矩阵的宽和高范围在 [1, 100]。 
// 给定的 r 和 c 都是正数。 
// 
// Related Topics 数组 
// 👍 194 👎 0


public class ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
        int[][] nums = solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            if (r * c != nums.length * nums[0].length) {
                return nums;
            }
            int m = nums.length;
            int n = nums[0].length;
            if (m * n != r * c) {
                return nums;
            }

            int[][] ans = new int[r][c];
            for (int x = 0; x < m * n; ++x) {
                ans[x / c][x % c] = nums[x / n][x % n];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}