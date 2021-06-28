package com.leetcode.editor.cn;

//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 61 👎 0


public class GetKthMagicNumberLcci {
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        System.out.println(solution.getKthMagicNumber(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            if (k == 1) {
                return 1;
            }
            int[] dp = new int[k];
            dp[0] = 1;
            int i3 = 0;
            int i5 = 0;
            int i7 = 0;
            for (int i = 1; i < k; i++) {
                int sum3 = dp[i3] * 3;
                int sum5 = dp[i5] * 5;
                int sum7 = dp[i7] * 7;
                int min = Math.min(Math.min(sum3, sum5), sum7);
                dp[i] = min;
                if (sum3 == min) {
                    i3++;
                }
                if (sum5 == min) {
                    i5++;
                }
                if (sum7 == min) {
                    i7++;
                }
            }
            return dp[k - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}