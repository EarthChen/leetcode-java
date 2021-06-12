package com.leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 124 👎 0


public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder sb = new StringBuilder();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                char ch = s.charAt(i);
                if (ch == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}