//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-sum/
//
// Related Topics 数学 字符串 模拟 👍 69 👎 0


package com.leetcode.editor.cn;

//Java：分割等和子集
public class PNUPfPrNUPfPr {
    public static void main(String[] args) {
        Solution solution = new PNUPfPrNUPfPr().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n <= 1) {
                return false;
            }
            int sum = 0;
            int max = nums[0];
            for (int num : nums) {
                sum += num;
                max = Math.max(num, max);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (max > target) {
                return false;
            }
            boolean[][] dp = new boolean[n][target + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                int curNum = nums[i];
                for (int j = 1; j <= target; j++) {
                    if (j >= curNum) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - curNum];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][target];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}