package com.leetcode.editor.cn;

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
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 数组 
// 👍 515 👎 0


import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int[] newNums = nums.clone();
            Arrays.sort(newNums);
            int first = Integer.MAX_VALUE;
            int end = 0;
            for (int i = 0; i < n; i++) {
                if (newNums[i] != nums[i]) {
                    first = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (newNums[i] != nums[i]) {
                    end = i;
                    break;
                }
            }
            int min = end - first;
            return min >= 0 ? min + 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}