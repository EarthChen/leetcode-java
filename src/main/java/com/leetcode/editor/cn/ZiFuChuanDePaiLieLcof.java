package com.leetcode.editor.cn;

//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 278 👎 0


import java.util.HashSet;
import java.util.Set;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {

        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        // String[] strings = solution.permutation("abc");
        // for (String string : strings) {
        //     System.out.println(string);
        // }
        // System.out.println();
        String[] strings2 = solution.permutation("aab");
        for (String string : strings2) {
            System.out.println(string);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private Set<String> ans = new HashSet<>();

        public String[] permutation(String s) {
            char[] chars = s.toCharArray();
            backtrack(chars, new StringBuilder(), new HashSet<>());
            return ans.toArray(new String[0]);
        }

        private void backtrack(char[] chars, StringBuilder sb, Set<Integer> indexSet) {
            if (sb.length() == chars.length) {
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (indexSet.contains(i)) {
                    continue;
                }
                sb.append(chars[i]);
                indexSet.add(i);
                backtrack(chars, sb,indexSet);
                sb.deleteCharAt(sb.length() - 1);
                indexSet.remove(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}