package com.leetcode.editor.cn;

//给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR)
// 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。 
//
// 示例 1: 
//
// 输入: s = "1^0|0|1", result = 0
//
//输出: 2
//解释: 两种可能的括号方法是
//1^(0|(0|1))
//1^((0|0)|1)
// 
//
// 示例 2: 
//
// 输入: s = "0&0&0&1^1|0", result = 1
//
//输出: 10 
//
// 提示： 
//
// 
// 运算符的数量不超过 19 个 
// 
// Related Topics 栈 字符串 
// 👍 43 👎 0


import java.util.Arrays;

public class BooleanEvaluationLcci {
    public static void main(String[] args) {
        Solution solution = new BooleanEvaluationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        private int getBoolAns(int val1, int val2, char operator) {
            switch (operator) {
                case '&':
                    return val1 & val2;
                case '|':
                    return val1 | val2;
                case '^':
                    return val1 ^ val2;
            }
            return val1 & val2;
        }


        public int countEval(String s, int result) {
            char[] arr = s.toCharArray();
            int length = s.length();
            int[][][] dp = new int[length][length][2];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return count(arr, dp, 0, length - 1, result);

        }

        private int count(char[] arr, int[][][] dp, int start, int end, int result) {
            if (start == end) {
                return arr[start] - '0' == result ? 1 : 0;
            }

            if (dp[start][end][result] != -1) {
                return dp[start][end][result];
            }
            int ansCount = 0;
            // 由于每两个数字中间一个操作符 所以+2
            // 中间一个为操作符
            for (int k = start; k < end; k += 2) {
                char operator = arr[k + 1];
                // 操作结果之后只有0和1
                for (int i = 0; i <= 1; i++) {
                    for (int j = 0; j <= 1; j++) {
                        // 枚举结果是否等于当前结果
                        if (getBoolAns(i, j, operator) == result) {
                            ansCount += count(arr, dp, start, k, i) * count(arr, dp, k + 2, end, j);
                        }
                    }
                }
            }

            dp[start][end][result] = ansCount;
            return ansCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}