package com.leetcode.editor.cn;

//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
// Related Topics 字符串 👍 401 👎 0


public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            int length = s.length();
            int i = length - 1;
            while (i >= 0) {
                char curChar = s.charAt(i);
                if (curChar == ' ') {
                    i--;
                } else {
                    break;
                }
            }
            int count = 0;
            while (i >= 0) {
                char curChar = s.charAt(i);
                if (curChar == ' ') {
                    break;
                } else {
                    i--;
                    count++;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}