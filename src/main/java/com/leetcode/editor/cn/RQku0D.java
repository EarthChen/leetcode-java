package com.leetcode.editor.cn;

//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 5 👎 0


public class RQku0D {
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome("abac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            int number = 0;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                    continue;
                }
                return validPalindromeHelper(s, i + 1, j) || validPalindromeHelper(s, i, j - 1);
            }
            return true;
        }


        public boolean validPalindromeHelper(String s, int front, int end) {
            while (front < end) {
                if (s.charAt(front) != s.charAt(end)) {
                    return false;
                }
                front++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}