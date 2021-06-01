package com.leetcode.editor.cn;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。 
//
// 示例 1： 
//
// 输入: s = "leetcode"
//输出: false 
// 
//
// 示例 2： 
//
// 输入: s = "abc"
//输出: true
// 
//
// 限制： 
// 
// 0 <= len(s) <= 100 
// 如果你不使用额外的数据结构，会很加分。 
// 
// Related Topics 数组 
// 👍 118 👎 0


public class IsUniqueLcci {
    public static void main(String[] args) {
        Solution solution = new IsUniqueLcci().new Solution();
        System.out.println(solution.isUnique("abc"));
        System.out.println(solution.isUnique("leetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUnique(String astr) {
            int mark = 0;
            int length = astr.length();
            for (int i = 0; i < length; i++) {
                char curChar = astr.charAt(i);
                int n = 1 << (curChar - 'a');
                if ((mark & n) != 0) {
                    return false;
                }
                mark = mark | n;
            }
            return true;

            // int length = astr.length();
            // if (length == 0) {
            //     return true;
            // }
            // Set<Character> set = new HashSet<>(length);
            // for (int i = 0; i < length; i++) {
            //     if (set.contains(astr.charAt(i))) {
            //         return false;
            //     }
            //     set.add(astr.charAt(i));
            // }
            // return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}