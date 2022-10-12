//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 2903 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ret = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(0, 0, n, new StringBuilder());
            return ret;
        }

        private void dfs(int l, int r, int n, StringBuilder sb) {
            if (sb.length() == 2 * n) {
                ret.add(sb.toString());
                return;
            }
            if (l < n) {
                sb.append("(");
                dfs(l + 1, r, n, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r < l) {
                sb.append(")");
                dfs(l, r + 1, n, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}