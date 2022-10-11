//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1262 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class P16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16ThreeSumClosest().new Solution();
        // int[] nums = new int[]{-1, 2, 1, -4};
        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};
        int ret = solution.threeSumClosest(nums, -2);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length;
            int diff = Integer.MAX_VALUE;
            int ret = 0;
            for (int i = 0; i < len - 2; i++) {
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    int curSum = nums[l] + nums[r];
                    int curTotalSum = curSum + nums[i];
                    if (curTotalSum == target) {
                        return curTotalSum;
                    }
                    int curDiff = Math.abs(curTotalSum - target);
                    if (curDiff < diff) {
                        diff = curDiff;
                        ret = curTotalSum;
                    }
                    if (curTotalSum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}