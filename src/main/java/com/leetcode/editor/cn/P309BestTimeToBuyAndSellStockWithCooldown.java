//给定一个整数数组
// prices，其中第 prices[i] 表示第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
//
// 示例 2: 
//
// 
//输入: prices = [1]
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1348 👎 0


package com.leetcode.editor.cn;

//Java：最佳买卖股票时机含冷冻期
public class P309BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new P309BestTimeToBuyAndSellStockWithCooldown().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            int[] dp1 = new int[len];
            dp1[0] = -prices[0];
            // 在冷冻
            int[] dp2 = new int[len];
            // 不在冷冻
            int[] dp3 = new int[len];
            for (int i = 1; i < len; i++) {
                // 持有股票： 1.昨天持有股票 2.本日买入（条件：昨天不持有，且不是卖出）
                dp1[i] = Math.max(dp1[i - 1], dp3[i - 1] - prices[i]);
                //本日卖出 : (条件:昨天持有)
                dp2[i] = dp1[i - 1] + prices[i];
                // 不持有，但也不是卖出 : 1.昨天卖出，不持有  2.昨天没卖出，但也不持有
                dp3[i] = Math.max(dp2[i - 1], dp3[i - 1]);
            }
            return Math.max(dp2[len - 1], dp3[len - 1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}