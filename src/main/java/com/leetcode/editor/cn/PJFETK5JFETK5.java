//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
//
// Related Topics 位运算 数学 字符串 模拟 👍 51 👎 0


package com.leetcode.editor.cn;

//Java：二进制加法
public class PJFETK5JFETK5 {
    public static void main(String[] args) {
        Solution solution = new PJFETK5JFETK5().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            StringBuilder ans = new StringBuilder();
            int n = Math.max(a.length(), b.length());
            int carry = 0;
            for (int i = 0; i < n; ++i) {
                carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
                carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
                ans.append((char) (carry % 2 + '0'));
                carry /= 2;
            }

            if (carry > 0) {
                ans.append('1');
            }
            ans.reverse();

            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}