package com.leetcode.editor.cn;

//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
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
// 👍 40 👎 0


import java.util.HashSet;
import java.util.Set;

public class PermutationIiLcci {
    public static void main(String[] args) {
        Solution solution = new PermutationIiLcci().new Solution();
        String[] strings = solution.permutation("qqe");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private HashSet<String> ans = new HashSet<>();

        public String[] permutation(String str) {
            char[] chars = str.toCharArray();
            backtrack(chars, new StringBuilder(), new HashSet<>());
            return ans.toArray(new String[0]);
        }

        private void backtrack(char[] chars, StringBuilder sb, Set<Integer> indexSet) {
            if (chars.length == sb.length()) {
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (indexSet.contains(i)) {
                    continue;
                }
                sb.append(chars[i]);
                indexSet.add(i);
                backtrack(chars, sb, indexSet);
                sb.deleteCharAt(sb.length() - 1);
                indexSet.remove(i);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}