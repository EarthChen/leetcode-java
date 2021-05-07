package com.leetcode.editor.cn;

//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 94 👎 0


public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            int length = s.length();
            if (length == 0) {
                return ' ';
            }
            if (length == 1) {
                return s.charAt(0);
            }
            int[] chars = new int[26];
            for (int i = 0; i < length; i++) {
                chars[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < length; i++) {
                if (chars[s.charAt(i) - 'a'] == 1) {
                    return s.charAt(i);
                }
            }

            // Map<Character, Integer> map = new HashMap<>();
            // for (int i = 0; i < length; i++) {
            //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            // }
            // for (int i = 0; i < length; i++) {
            //     if (map.get(s.charAt(i)) == 1) {
            //         return s.charAt(i);
            //     }
            // }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}