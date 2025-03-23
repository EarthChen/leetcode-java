//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2401 👎 0


package com.leetcode.editor.cn;

//Java：乘积最大子数组
public class PMaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new PMaximumProductSubarray().new Solution();

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int maxI = 1;
            int minI = 1;
            for (int num : nums) {
                if (num < 0) {
                    int tmp = maxI;
                    maxI = minI;
                    minI = tmp;
                }
                maxI = Math.max(maxI * num, num);
                minI = Math.min(minI * num, num);
                max = Math.max(max, maxI);

            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}