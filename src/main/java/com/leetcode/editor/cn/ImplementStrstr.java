package com.leetcode.editor.cn;

//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 689 👎 0


public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("mississippi","issip"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.length() == 0) {
                return 0;
            }
            int needLength = needle.length();
            int sourceLength = haystack.length();
            if (needLength > sourceLength) {
                return -1;
            }
            char needFirstChar = needle.charAt(0);
            for (int i = 0; i < sourceLength; i++) {
                char currentChar = haystack.charAt(i);
                if (currentChar == needFirstChar) {
                    int end = i + needLength;
                    if (end > sourceLength) {
                        return -1;
                        // end = sourceLength;
                    }
                    for (int j = 0; j < needLength; j++) {
                        if (haystack.charAt(i+j) != needle.charAt(j)) {
                            break;
                        }
                        if (j == needLength - 1) {
                            return i;
                        }
                    }
                    // int x = i + 1;
                    // for (int j = x; j < end; j++) {
                    //     if (haystack.charAt(i) == needle.charAt(i)) {
                    //         x++;
                    //     }
                    // }
                    // return x;
                    // String s = haystack.substring(i, end);
                    // if (s.equals(needle)) {
                    //     return i;
                    // }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}