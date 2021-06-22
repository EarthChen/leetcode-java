package com.leetcode.editor.cn;

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 177 👎 0


public class ChouShuLcof {
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int a = 0;
            int b = 0;
            int c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for (int i = 1; i < n; i++) {
                int n2 = dp[a] * 2;
                int n3 = dp[b] * 3;
                int n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if (dp[i] == n2) {
                    a++;
                }
                if (dp[i] == n3) {
                    b++;
                }
                if (dp[i] == n5) {
                    c++;
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}