//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 2573 👎 0


package com.leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            int len = prefix.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char chr = prefix.charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    String str = strs[j];
                    if (i >= str.length()) {
                        return sb.toString();
                    }
                    if (str.charAt(i) != chr) {
                        return sb.toString();
                    }
                }
                sb.append(chr);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}