package com.leetcode.editor.cn;

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
// Related Topics 字符串 回溯算法 
// 👍 1662 👎 0


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<>();
            backtrack(ret, new StringBuilder(), 0, 0, n);
            return ret;
        }

        public void backtrack(List<String> ret, StringBuilder str, int left, int right, int n) {
            if (str.length() == n * 2) {
                ret.add(str.toString());
                return;
            }
            if (left < n) {
                str.append('(');
                backtrack(ret, str, left + 1, right, n);
                str.deleteCharAt(str.length() - 1);
            }
            if (right < left) {
                str.append(')');
                backtrack(ret, str, left, right + 1, n);
                str.deleteCharAt(str.length() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}