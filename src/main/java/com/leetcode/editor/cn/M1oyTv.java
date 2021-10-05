package com.leetcode.editor.cn;

//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-substring/
// Related Topics 哈希表 字符串 滑动窗口 👍 6 👎 0


import java.util.HashMap;
import java.util.Map;

public class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
        // System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae"));
        // System.out.println(solution.minWindow("a", "aa"));
        // System.out.println(solution.minWindow("a", "a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            int count = map.size();
            int lastL = 0;
            int i = 0;
            int j = 0;
            int min = Integer.MAX_VALUE;
            while (i <= j && j < s.length()) {
                char cur = s.charAt(j);
                Integer num = map.get(cur);
                if (num == null) {
                    j++;
                    continue;
                }
                num--;
                map.put(cur, num);
                if (num == 0) {
                    count--;
                    if (count == 0) {
                        while (i < s.length()) {
                            Integer iNum = map.get(s.charAt(i));
                            if (iNum == null) {
                                i++;
                                continue;
                            }
                            if (iNum < 0) {
                                map.put(s.charAt(i), iNum + 1);
                                i++;
                                continue;
                            }
                            break;
                        }
                        if (j - i + 1 < min) {
                            min = j - i + 1;
                            lastL = i;
                        }
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        i++;
                        count++;
                    }
                }
                j++;
            }
            return min == Integer.MAX_VALUE ? "" : s.substring(lastL, lastL + min);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}