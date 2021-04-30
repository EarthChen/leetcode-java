package com.leetcode.editor.cn;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模100
//0000007。 
//
// 示例1: 
//
// 
// 输入：n = 3 
// 输出：4
// 说明: 有四种走法
// 
//
// 示例2: 
//
// 
// 输入：n = 5
// 输出：13
// 
//
// 提示: 
//
// 
// n范围在[1, 1000000]之间 
// 
// Related Topics 动态规划 
// 👍 53 👎 0


public class ThreeStepsProblemLcci {
    public static void main(String[] args) {
        Solution solution = new ThreeStepsProblemLcci().new Solution();
        // System.out.println(solution.waysToStep(5));
        // System.out.println(solution.waysToStep(61));
        System.out.println(solution.waysToStep(76));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int waysToStep(int n) {
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            if (n == 3) {
                return 4;
            }

            int dp1 = 1;
            int dp2 = 2;
            int dp3 = 4;
            int dp4 = 0;

            for (int i = 4; i <= n; ++i) {
                dp4 = ((dp1 + dp2) % 1000000007 + dp3) % 1000000007;
                dp1 = dp2;
                dp2 = dp3;
                dp3 = dp4;
            }

            return dp4;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}