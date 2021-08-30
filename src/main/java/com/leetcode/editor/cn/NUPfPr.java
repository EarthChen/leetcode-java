package com.leetcode.editor.cn;

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
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
// Related Topics 数组 动态规划 👍 2 👎 0


public class NUPfPr {
    public static void main(String[] args) {
        Solution solution = new NUPfPr().new Solution();
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) return false;
            boolean[][] booleans = new boolean[nums.length][sum + 1];
            booleans[0][nums[0]] = true;
            for (int i = 1; i < nums.length; i++) {
                for (int s = 1; s < sum; s++) {
                    booleans[i][s] = booleans[i - 1][s];
                    if (s - nums[i] >= 0) booleans[i][s] |= booleans[i - 1][s - nums[i]];
                }
            }
            return booleans[nums.length - 1][(sum / 2)];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}