package com.leetcode.editor.cn;

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 231 
// 
// 👍 232 👎 0


public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(12258));
        System.out.println(solution.translateNum(26));
        System.out.println(solution.translateNum(506));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            String str = String.valueOf(num);
            int length = str.length();
            if (length <= 1) {
                return 1;
            }
            int[] dp = new int[length + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= length; i++) {
                dp[i] = dp[i - 1];
                int lastNum = str.charAt(i - 2) - '0';
                int curNum = str.charAt(i - 1) - '0';
                int ret = lastNum * 10 + curNum;
                if (ret <= 25 && ret >= 10) {
                    dp[i] = dp[i] + dp[i - 2];
                }
            }
            return dp[length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}