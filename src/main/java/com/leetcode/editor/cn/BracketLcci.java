package com.leetcode.editor.cn;

//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法 
// 👍 67 👎 0


import java.util.ArrayList;
import java.util.List;

public class BracketLcci {
    public static void main(String[] args) {
        Solution solution = new BracketLcci().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            backtrack(ans, new StringBuilder(), 0, 0, n);
            return ans;
        }

        private void backtrack(List<String> ret, StringBuilder str, int left, int right, int n) {
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