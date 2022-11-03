//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
//
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 955 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

//Java：最短无序连续子数组
public class P581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        int ret = solution.findUnsortedSubarray(nums);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int len = nums.length;
            int[] sortNums = new int[len];
            System.arraycopy(nums, 0, sortNums, 0, len);
            Arrays.sort(sortNums);
            int l = 0;
            while (l < len) {
                if (sortNums[l] == nums[l]) {
                    l++;
                } else {
                    break;
                }
            }
            int r = len - 1;
            while (r >= 0) {
                if (sortNums[r] == nums[r]) {
                    r--;
                } else {
                    break;
                }
            }
            if (r == -1 && l == len) {
                return 0;
            }
            return r - l + 1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}