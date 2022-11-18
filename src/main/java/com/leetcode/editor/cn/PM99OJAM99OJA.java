//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
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
//输出：[["a"]] 
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
// 
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 43 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：分割回文子字符串
public class PM99OJAM99OJA {
    public static void main(String[] args) {
        Solution solution = new PM99OJAM99OJA().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[][] f;
        List<List<String>> ret = new ArrayList<>();
        int n;

        public String[][] partition(String s) {
            n = s.length();
            f = new boolean[n][n];
            for (int i = 0; i < n; ++i) {
                Arrays.fill(f[i], true);
            }

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i + 1; j < n; ++j) {
                    f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
                }
            }

            dfs(s, 0, new ArrayList<>());
            return ret.stream().map(it -> it.toArray(new String[0])).toArray(String[][]::new);
        }

        public void dfs(String s, int i, List<String> ans) {
            if (i == n) {
                ret.add(new ArrayList<>(ans));
                return;
            }
            for (int j = i; j < n; ++j) {
                if (f[i][j]) {
                    ans.add(s.substring(i, j + 1));
                    dfs(s, j + 1, ans);
                    ans.remove(ans.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}