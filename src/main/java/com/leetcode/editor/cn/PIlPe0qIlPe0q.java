//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// 
//
// 
// 注意：本题与主站 120 题相同： https://leetcode-cn.com/problems/triangle/ 
//
// Related Topics 数组 动态规划 👍 26 👎 0


package com.leetcode.editor.cn;

import java.util.List;

//Java：三角形中最小路径之和
public class PIlPe0qIlPe0q {
    public static void main(String[] args) {
        Solution solution = new PIlPe0qIlPe0q().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] f = new int[n][n];
            f[0][0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
                for (int j = 1; j < i; ++j) {
                    f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
                }
                f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            }
            int minTotal = f[n - 1][0];
            for (int i = 1; i < n; ++i) {
                minTotal = Math.min(minTotal, f[n - 1][i]);
            }
            return minTotal;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}