package com.leetcode.editor.cn;

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
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1439 👎 0


public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"cir", "car"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 纵向比较
         *
         * @param strs
         * @return
         */
        // public String longestCommonPrefix(String[] strs) {
        //     if (strs == null || strs.length == 0) {
        //         return "";
        //     }
        //     int length = strs[0].length();
        //     int count = strs.length;
        //     for (int i = 0; i < length; i++) {
        //         char c = strs[0].charAt(i);
        //         for (int j = 1; j < count; j++) {
        //             if (i == strs[j].length() || strs[j].charAt(i) != c) {
        //                 return strs[0].substring(0, i);
        //             }
        //         }
        //     }
        //     return strs[0];
        // }
        /**
         * 横线比较
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String prefix = strs[0];
            // int maxLength = strs[0].length();
            for (int i = 1; i < strs.length; i++) {
                prefix = getCommonPrefix(strs[i], prefix);
                if (prefix.length() == 0) {
                    break;
                }
            }
            return prefix;
        }
        private String getCommonPrefix(String str1, String str2) {
            int length = Math.min(str1.length(), str2.length());
            int index = 0;
            while (index < length && str1.charAt(index) == str2.charAt(index)) {
                index++;
            }
            return str1.substring(0, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}