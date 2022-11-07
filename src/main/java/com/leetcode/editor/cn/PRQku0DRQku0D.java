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
// 
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
//
// Related Topics 贪心 双指针 字符串 👍 54 👎 0


package com.leetcode.editor.cn;

//Java：最多删除一个字符得到回文
public class PRQku0DRQku0D {
    public static void main(String[] args) {
        Solution solution = new PRQku0DRQku0D().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int len = s.length();
            int l = 0;
            int r = len - 1;
            while (l < r) {
                if (s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                    continue;
                }
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
            return true;
        }

        public boolean validPalindrome(String s, int low, int high) {
            for (int i = low, j = high; i < j; ++i, --j) {
                char c1 = s.charAt(i), c2 = s.charAt(j);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}