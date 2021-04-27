package com.leetcode.editor.cn;

//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 471 👎 0


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            return dfs(s, k);
        }

        private int dfs(String s, int k) {
            //统计每个字符出现的次数
            // int[] charCount = new int[26];
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char curChar = s.charAt(i);
                Integer num = map.get(curChar);
                if (num == null) {
                    num = 0;
                }
                num++;
                map.put(curChar, num);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() < k) {
                    String[] split1 = s.split(String.valueOf(entry.getKey()));
                    int max = 0;
                    for (String s1 : split1) {
                        int dfs = dfs(s1, k);
                        max = Math.max(max, dfs);
                    }
                    return max;
                }
            }
            // 全部大于 k
            return s.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}