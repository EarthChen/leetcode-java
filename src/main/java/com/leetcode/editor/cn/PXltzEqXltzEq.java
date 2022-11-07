//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
//
// Related Topics 双指针 字符串 👍 35 👎 0


package com.leetcode.editor.cn;

//Java：有效的回文
public class PXltzEqXltzEq {
    public static void main(String[] args) {
        Solution solution = new PXltzEqXltzEq().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int len = s.length();
            int l = 0;
            int r = len - 1;
            while (l < r) {
                while (l < r && !isValid(s.charAt(l))) {
                    l++;
                }
                while (l < r && !isValid(s.charAt(r))) {
                    r--;
                }
                if (l < r) {
                    if (!equal(s.charAt(l), s.charAt(r))) {
                        return false;
                    }
                    l++;
                    r--;
                }
            }
            return true;
        }

        private boolean equal(char a, char b) {
            if (a == b) {
                return true;
            }
            if (a >= 'a' && a <= 'z') {
                a -= 32;
            }

            if (b >= 'a' && b <= 'z') {
                b -= 32;
            }
            return a == b;
        }

        private boolean isValid(char chr) {
            if (chr >= '0' && chr <= '9') {
                return true;
            }
            if (chr >= 'a' && chr <= 'z') {
                return true;
            }
            if (chr >= 'A' && chr <= 'Z') {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}