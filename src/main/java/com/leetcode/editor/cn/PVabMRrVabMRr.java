//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2： 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 39 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：字符串中的所有变位词
public class PVabMRrVabMRr {
    public static void main(String[] args) {
        Solution solution = new PVabMRrVabMRr().new Solution();
        String s = "abab";
        String p = "ab";
        List<Integer> ans = solution.findAnagrams(s, p);
        System.out.println(ans);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int n = p.length();
            int m = s.length();
            List<Integer> ans = new ArrayList<>();
            if (n > m) {
                return ans;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < n; i++) {
                cnt[p.charAt(i) - 'a']--;
            }
            for (int right = 0, left = 0; right < m; right++) {
                int c = s.charAt(right) - 'a';
                cnt[c]++;
                while (cnt[c] > 0) {
                    cnt[s.charAt(left++) - 'a']--;
                }
                if (right - left + 1 == n){
                    ans.add(left);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}