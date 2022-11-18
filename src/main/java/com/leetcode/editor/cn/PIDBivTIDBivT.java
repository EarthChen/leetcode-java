//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
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
// 
//
// 
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
//
// Related Topics 字符串 动态规划 回溯 👍 51 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：生成匹配的括号
public class PIDBivTIDBivT {
    public static void main(String[] args) {
        Solution solution = new PIDBivTIDBivT().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> ret = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs(n,0,0,new StringBuilder());
            return ret;
        }

        private void dfs(int n, int l, int r, StringBuilder sb) {
            if (sb.length() == n * 2) {
                ret.add(sb.toString());
                return;
            }
            if (l < n) {
                sb.append("(");
                dfs(n, l + 1, r, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r < l) {
                sb.append(")");
                dfs(n, l, r + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}