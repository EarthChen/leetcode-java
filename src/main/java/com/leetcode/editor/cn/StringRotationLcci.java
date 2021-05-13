package com.leetcode.editor.cn;

//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 
// 👍 70 👎 0


public class StringRotationLcci {
    public static void main(String[] args) {
        Solution solution = new StringRotationLcci().new Solution();
        System.out.println(solution.isFlipedString("waterbottle", "erbottlewat"));
        System.out.println(solution.isFlipedString("ab", "ba"));
        System.out.println(solution.isFlipedString("aba", "bab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            if (length1 != length2) {
                return false;
            }
            String newStr = s2 + s2;
            return newStr.contains(s1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}