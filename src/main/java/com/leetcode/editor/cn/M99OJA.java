package com.leetcode.editor.cn;

//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 👍 2 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        System.out.println(solution.partition("google"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String[]> ans = new ArrayList<>();

        private boolean[][] dp;

        public String[][] partition(String s) {
            int length = s.length();
            dp = new boolean[length][length];
            for (int i = 0; i < length; ++i) {
                Arrays.fill(dp[i], true);
            }
            for (int i = length - 1; i >= 0; i--) {
                for (int j = i+1; j < length; j++) {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
            }
            dfs(s, 0, new ArrayList<>());
            return ans.toArray(new String[0][]);
        }

        private void dfs(String chars, int i, List<String> list) {
            if (i == chars.length()) {
                ans.add(list.toArray(new String[0]));
                return;
            }
            for (int j = i; j < chars.length(); j++) {
                if (dp[i][j]) {
                    list.add(chars.substring(i, j + 1));
                    dfs(chars, j + 1, list);
                    list.remove(list.size() - 1);
                }
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}