package com.leetcode.editor.cn;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 915 👎 0


public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = findIndex(nums, target, 0, nums.length - 1);
            int[] ret = new int[2];
            if (index == -1) {
                ret[0] = -1;
                ret[1] = -1;
                return ret;
            }
            int i = index;
            while (i >= 0) {
                if (nums[i] != target) {
                    break;
                }
                i--;
            }
            int j = index;
            while (j < nums.length) {
                if (nums[j] != target) {
                    break;
                }
                j++;
            }
            ret[0] = i + 1;
            ret[1] = j - 1;
            return ret;
        }

        private int findIndex(int[] nums, int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            int midIndex = left + (right - left) / 2;
            int midNum = nums[midIndex];
            if (midNum > target) {
                return findIndex(nums, target, left, midIndex - 1);
            } else if (midNum < target) {
                return findIndex(nums, target, midIndex + 1, right);
            } else {
                return midIndex;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}