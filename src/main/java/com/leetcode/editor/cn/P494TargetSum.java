//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1420 👎 0


package com.leetcode.editor.cn;

//Java：目标和
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int ret = solution.findTargetSumWays(nums, 3);

        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums, 0, target);
            return count;
        }

        private void dfs(int[] nums, int index, int target) {
            if (index >= nums.length) {
                return;
            }
            int target1 = target - nums[index];
            int target2 = target + nums[index];
            if (index == nums.length - 1) {
                if (target1 == 0) {
                    count++;
                }
                if (target2 == 0) {
                    count++;
                }
            }
            dfs(nums, index + 1, target1);
            dfs(nums, index + 1, target2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}