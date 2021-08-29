package com.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// 
//
// 注意：本题与主站 3 题相同： https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 2 👎 0


import java.util.HashMap;
import java.util.Map;

public class WtcaE1 {
    public static void main(String[] args) {
        Solution solution = new WtcaE1().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charNumMap = new HashMap<>();
            int length = s.length();
            int count = 0;
            int i = 0;
            int j = 0;
            while (j < length) {
                char jChar = s.charAt(j);
                Integer jNum = charNumMap.get(jChar);
                if (jNum == null || jNum <= 0) {
                    j++;
                    charNumMap.put(jChar, 1);
                    count = Math.max(j - i, count);
                    continue;
                }
                j++;
                jNum++;
                charNumMap.put(jChar, jNum);
                while (i < j) {
                    char iChar = s.charAt(i);
                    charNumMap.put(iChar, charNumMap.getOrDefault(iChar, 0) - 1);
                    i++;
                    if (iChar == jChar) {
                        break;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}