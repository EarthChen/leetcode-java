//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 5781 👎 0


package com.leetcode.editor.cn;

//Java：最长回文子串
public class P5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            int start = 0;
            int end = 0;
            int max = 1;
            for (int i = 1; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    boolean equal = s.charAt(j) == s.charAt(i);
                    if (equal && (i - j <= 2 || dp[j + 1][i - 1] == 1)) {
                        dp[j][i] = 1;
                        int curMax = i - j + 1;
                        if (curMax > max) {
                            max = curMax;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
            return s.substring(start, end + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}