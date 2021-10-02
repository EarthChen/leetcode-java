package com.leetcode.editor.cn;

//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 6 👎 0


public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
        System.out.println(solution.countSubstrings("abc"));
        System.out.println(solution.countSubstrings("aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int count = 0;
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i; j < length; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1) {
                            dp[i][j] = true;
                            count++;
                        } else if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            count++;
                        }
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}