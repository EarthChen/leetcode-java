package com.leetcode.editor.cn;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 双指针 Sliding Window 
// 👍 205 👎 0


import java.util.HashMap;

public class ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            int left = 0;
            int right = 0;
            int res = 0;
            while (right < s.length()) {
                char ch = s.charAt(right);
                // 当前值已经出现过了，更新左边界
                if (hashMap.containsKey(ch)) {
                    // 另 left = 当前值最后一次出现的地方 + 1 ，使得[left,right]无重复值
                    // 需要取较大值
                    left = Math.max(left, hashMap.get(ch) + 1);
                }
                //更新最后出现下标
                hashMap.put(ch, right);
                // [left,right]的长度
                res = Math.max(res, right - left + 1);
                right++;
            }
            return res;

            // Map<Integer, Set<Character>> map = new HashMap<>(length);
            // Set<Character> firstSet = new HashSet<>();
            // firstSet.add(s.charAt(0));
            // map.put(0, firstSet);
            // int max = 1;
            // for (int i = 1; i < length; i++) {
            //     Set<Character> lastSet = map.get(i - 1);
            //     char curChar = s.charAt(i);
            //     if (lastSet.contains(curChar)) {
            //         int j = i;
            //         Set<Character> curSet = new HashSet<>();
            //         while (!curSet.contains(curChar)) {
            //             curSet.add(curChar);
            //             j--;
            //             curChar = s.charAt(j);
            //         }
            //         map.put(i, curSet);
            //         max = Math.max(curSet.size(), max);
            //     } else {
            //         Set<Character> curSet = new HashSet<>(lastSet);
            //         curSet.add(curChar);
            //         max = Math.max(curSet.size(), max);
            //         map.put(i, curSet);
            //     }
            // }
            // return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}