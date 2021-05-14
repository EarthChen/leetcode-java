package com.leetcode.editor.cn;

//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 字符串 
// 👍 114 👎 0


public class ZuoXuanZhuanZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new ZuoXuanZhuanZiFuChuanLcof().new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseLeftWords(String s, int n) {
            return (s + s).substring(n, s.length() + n);

            // StringBuilder res = new StringBuilder();
            // for(int i = n; i < n + s.length(); i++) {
            //     res.append(s.charAt(i % s.length()));
            // }
            // return res.toString();


            // int length = s.length();
            // int k = n % length;
            // char[] chars = s.toCharArray();
            // reverse(chars, 0, length - 1);
            // reverse(chars, 0, length - k - 1);
            // reverse(chars, length - k, length - 1);
            // return new String(chars);


            // StringBuilder sb = new StringBuilder(s);
            // sb = sb.reverse();
            // return new StringBuilder(sb.substring(0, length - k)).reverse()
            //         .append(new StringBuilder(sb.substring(length - k, length)).reverse())
            //         .toString();
        }

        private void reverse(char[] chars, int start, int end) {
            int i = start;
            int j = end;
            while (i < j) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        private void swap(char[] chars, int i, int j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}