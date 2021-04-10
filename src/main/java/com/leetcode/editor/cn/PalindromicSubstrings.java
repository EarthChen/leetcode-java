package com.leetcode.editor.cn;

//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 542 👎 0


public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aa"));
        System.out.println(solution.countSubstrings("aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int ans = 0;

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    boolean b = s.charAt(i) == s.charAt(j);
                    // 相邻两个一致是回文
                    if (b && j - i < 2) {
                        dp[i][j] = true;
                        ans++;
                    // 去除左右最外的字符还是回文
                    } else if (b && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ans++;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}