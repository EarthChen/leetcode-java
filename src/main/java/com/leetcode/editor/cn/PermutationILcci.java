package com.leetcode.editor.cn;

//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 47 👎 0


import java.util.ArrayList;
import java.util.List;

public class PermutationILcci {
    public static void main(String[] args) {
        Solution solution = new PermutationILcci().new Solution();
        String[] ans = solution.permutation("qwe");
        for (String an : ans) {
            System.out.println(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<String> ans = new ArrayList<>();

        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
            backtrack(chars, new StringBuilder());
            return ans.toArray(new String[0]);
        }

        private void backtrack(char[] chars, StringBuilder sb) {
            if (sb.length() == chars.length) {
                ans.add(new String(sb));
                return;
            }

            for (char aChar : chars) {
                if (sb.indexOf(aChar + "") != -1) {
                    continue;
                }
                sb.append(aChar);
                backtrack(chars, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}