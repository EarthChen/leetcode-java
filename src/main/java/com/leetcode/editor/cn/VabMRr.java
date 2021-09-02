package com.leetcode.editor.cn;

//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2: 
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
// Related Topics 哈希表 字符串 滑动窗口 👍 0 👎 0


import java.util.ArrayList;
import java.util.List;

public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd","abc"));
        System.out.println(solution.findAnagrams("abab","ab"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLength = s.length();
            int pLength = p.length();
            if (pLength > sLength) {
                return new ArrayList<>();
            }
            int[] pChar = new int[26];
            for (int i = 0; i < pLength; i++) {
                pChar[p.charAt(i) - 'a']++;
            }
            List<Integer> ans = new ArrayList<>();
            int l = 0;
            for (int i = 0; i < sLength; i++) {
                int x = s.charAt(i) - 'a';
                pChar[x]--;
                while (pChar[x] < 0) {
                    pChar[s.charAt(l) - 'a']++;
                    l++;
                }
                if (i - l + 1 == pLength) {
                    ans.add(l);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}