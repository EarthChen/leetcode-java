//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1978 👎 0


package com.leetcode.editor.cn;

//Java：不同的二叉搜索树
public class P96UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new P96UniqueBinarySearchTrees().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                // 以 j 为头结点时候的数量
                for (int j = 1; j <= i; j++) {
                    // 左边数量*右边数量
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}