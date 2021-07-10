package com.leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 
// 👍 1233 👎 0


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC","ABC"));
        System.out.println(solution.minWindow("bba","ab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> charNumMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                charNumMap.put(t.charAt(i), charNumMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            int diffCharSize = charNumMap.size();
            int start = 0;
            int end = 0;
            int minLength = Integer.MAX_VALUE;
            String minStr = "";
            while (end < s.length()) {
                char curChar = s.charAt(end);
                Integer curCharNum = charNumMap.get(curChar);
                if (curCharNum == null) {
                    end++;
                    continue;
                }
                curCharNum--;
                charNumMap.put(curChar, curCharNum);
                if (curCharNum > 0) {
                    end++;
                    continue;
                }
                if (curCharNum == 0) {
                    diffCharSize--;
                }
                if (diffCharSize > 0) {
                    end++;
                    continue;
                }
                while (start < end) {
                    char startChar = s.charAt(start);
                    Integer startCharNum = charNumMap.get(startChar);
                    if (startCharNum == null) {
                        start++;
                        continue;
                    }
                    if (startCharNum < 0) {
                        startCharNum++;
                        charNumMap.put(startChar, startCharNum);
                        start++;
                        continue;
                    }
                    break;
                }
                int curLength = end - start;
                if (curLength < minLength) {
                    minStr = s.substring(start, end+1);
                    minLength = curLength;
                }
                end++;
            }
            return minStr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}