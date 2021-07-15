package com.leetcode.editor.cn;

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1369 👎 0


public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()()"));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses(")("));
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int length = s.length();
            int[] dp = new int[length];
            for (int i = 1; i < length; i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = 2;
                        if (i >= 2) {
                            dp[i] += dp[i - 2];
                        }
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] >= 2) {
                            dp[i] += dp[i - dp[i - 1] - 2];
                        }
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
            // int length = s.length();
            // int[][] dp = new int[length][length];
            // int max = 0;
            // for (int i = 0; i < length; i++) {
            //     for (int j = i; j < length; j++) {
            //         if (i == j) {
            //             dp[i][j] = getNumber(s, i);
            //             continue;
            //         }
            //         if (dp[i][j - 1] < 0) {
            //             dp[i][j] = dp[i][j-1];
            //             continue;
            //         }
            //         dp[i][j] = dp[i][j - 1] + getNumber(s, j);
            //         if (dp[i][j] == 0) {
            //             max = Math.max(max, j - i + 1);
            //         }
            //     }
            // }
            // return max;
        }

        // private int getNumber(String s, int i) {
        //     char cur = s.charAt(i);
        //     if (cur == '(') {
        //         return 1;
        //     }
        //     return -1;
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}