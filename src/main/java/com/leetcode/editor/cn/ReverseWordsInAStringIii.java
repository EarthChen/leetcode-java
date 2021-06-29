package com.leetcode.editor.cn;

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 297 👎 0


public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
        // System.out.println(solution.reverseWords("Let's take LeetCode contest"));
        System.out.println(solution.reverseWords("I love u"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int length = s.length();
            int i = 0;
            int j = 0;
            StringBuilder sb = new StringBuilder();
            String[] strs = s.split(" ");
            for (String str : strs) {
                char[] subChars = str.toCharArray();
                reverseString(subChars);
                sb.append(subChars).append(' ');
            }
            return sb.toString().trim();
        }

        public void reverseString(char[] s) {
            int i = 0;
            int j = s.length - 1;
            while (i < j) {
                swap(s, i, j);
                i++;
                j--;
            }

        }

        private void swap(char[] s, int i, int j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}