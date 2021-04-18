package com.leetcode.editor.cn;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 369 👎 0


public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            while (i <= j) {
                char iChar = Character.toLowerCase(s.charAt(i));
                if (!isLegal(iChar)) {
                    i++;
                    continue;
                }
                char jChar = Character.toLowerCase(s.charAt(j));
                if (!isLegal(jChar)) {
                    j--;
                    continue;
                }
                if (iChar != jChar) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }


        private boolean isLegal(char c) {
            if (c >= 'a' && c <= 'z') {
                return true;
            }
            return c >= '0' && c <= '9';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}