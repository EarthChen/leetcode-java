package com.leetcode.editor.cn;

//URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
//请使用字符数组实现，以便直接在数组上操作。） 
//
// 
//
// 示例 1： 
//
// 
//输入："Mr John Smith    ", 13
//输出："Mr%20John%20Smith"
// 
//
// 示例 2： 
//
// 
//输入："               ", 5
//输出："%20%20%20%20%20"
// 
//
// 
//
// 提示： 
//
// 
// 字符串长度在 [0, 500000] 范围内。 
// 
// Related Topics 字符串 
// 👍 38 👎 0


public class StringToUrlLcci {
    public static void main(String[] args) {
        Solution solution = new StringToUrlLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpaces(String S, int length) {
            char[] chars = S.toCharArray();
            int index = chars.length - 1;
            for (int i = length - 1; i >= 0; i--) {
                //如果遇到空格就把他转化为"%20"
                if (chars[i] == ' ') {
                    chars[index--] = '0';
                    chars[index--] = '2';
                    chars[index--] = '%';
                } else {
                    chars[index--] = chars[i];
                }
            }
            return new String(chars, index + 1, chars.length - index - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}