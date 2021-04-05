package com.leetcode.editor.cn;

//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 821 👎 0


public class PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new PerfectSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            //dp[i]:构成数i的最小的完全平方和
            //dp[i] = min(dp[i-j*j] + 1 , min);     dp[i] = min(dp[i-k] + 1 ) k:1~ i-k*k >=0
            for (int i = 1; i <= n; i++) {//每个数的最小的完全平方和
                int min = i;
                for (int j = 1; i - j * j >= 0; j++) {
                    min = Math.min(dp[i - j * j] + 1, min); //min:这个数i中本次的min
                }
                dp[i] = min;
            }
            return dp[n];

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}