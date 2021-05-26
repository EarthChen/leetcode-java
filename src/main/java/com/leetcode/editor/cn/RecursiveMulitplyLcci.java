package com.leetcode.editor.cn;

//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 递归 
// 👍 43 👎 0


public class RecursiveMulitplyLcci {
    public static void main(String[] args) {
        Solution solution = new RecursiveMulitplyLcci().new Solution();
        System.out.println(solution.multiply(3, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int multiply(int A, int B) {
            if (A > B) {
                int T = A;
                A = B;
                B = T;
            }
            return dfs(A, B);
        }

        private int dfs(int a, int b) {
            if (a == 0) {
                return 0;
            }
            if (a == 1) {
                return b;
            }
            if (a == 2) {
                return b << 1;
            }
            return dfs(2, b) + dfs(a - 2, b);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}