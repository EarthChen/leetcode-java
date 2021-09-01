package com.leetcode.editor.cn;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 3 👎 0


public class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int length1 = s1.length();
            int length2 = s2.length();
            if (length2 < length1) {
                return false;
            }
            int[] cnt = new int[26];
            for (int i = 0; i < length1; ++i) {
                cnt[s1.charAt(i) - 'a']--;
            }
            int left = 0;
            for (int right = 0; right < length2; right++) {
                int x = s2.charAt(right) - 'a';
                cnt[x]++;
                while (cnt[x] > 0) {
                    cnt[s2.charAt(left) - 'a']--;
                    left++;
                }
                if (right - left + 1 == length1) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}