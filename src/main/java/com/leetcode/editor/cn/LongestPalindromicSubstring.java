package com.leetcode.editor.cn;

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
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3155 👎 0


public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 中心扩展法
         *
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s.length() <= 1) {
                return s;
            }
            int strLength = s.length();
            boolean[][] dp = new boolean[strLength][strLength];
            int max = 1;
            int left = 0;
            for (int r = 0; r < strLength; r++) {
                for (int l = 0; l < r; l++) {
                    if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])){
                        dp[l][r] = true;
                        if (r - l + 1 > max) {
                            left = l;
                            max = r - l + 1;
                        }
                    }
                }
            }
            return s.substring(left, max + left);


            // if (s.length() <= 1) {
            //     return s;
            // }
            // int strLength = s.length();
            // int max = 0;
            // int maxStart = 0;
            // for (int i = 0; i < strLength; i++) {
            //     int currentMax = 1;
            //     int left = i - 1;
            //     int right = i + 1;
            //     int currentStr = s.charAt(i);
            //     // 向左扩散
            //     while (left >= 0 && currentStr == s.charAt(left)) {
            //         left--;
            //         currentMax++;
            //     }
            //     // 向右扩散
            //     while (right < strLength && currentStr == s.charAt(right)) {
            //         right++;
            //         currentMax++;
            //     }
            //     // 同时向左向右扩散
            //     while (left >= 0 && right < strLength && s.charAt(left) == s.charAt(right)) {
            //         currentMax += 2;
            //         left--;
            //         right++;
            //     }
            //     if (currentMax > max) {
            //         max = currentMax;
            //         maxStart = left;
            //     }
            // }
            // // 由于经过 for 循环所有值都—1 所以需要+1
            // return s.substring(maxStart + 1, maxStart + max + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}