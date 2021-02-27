package com.leetcode.editor.cn;

//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 171 👎 0


public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        System.out.println(solution.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max += nums[i];
            }
            int currentMax = max;
            int i = k;
            while (i < nums.length) {
                currentMax = currentMax - nums[i - k] + nums[i];
                if (currentMax > max) {
                    max = currentMax;
                }
                i++;
            }
            return max * 1.0 / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}