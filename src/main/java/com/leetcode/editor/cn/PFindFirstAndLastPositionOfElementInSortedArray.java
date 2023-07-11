//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
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
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2361 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.PrintUtil;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class PFindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new PFindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{2};
        int[] result = solution.searchRange(nums, 2);
        PrintUtil.print(result);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int midVal = nums[mid];
                if (midVal == target) {
                    int l2 = mid;
                    while (l2 > 0) {
                        if (nums[l2 - 1] == midVal) {
                            l2--;
                        } else {
                            break;
                        }
                    }
                    int r2 = mid;
                    while (r2 < nums.length - 1) {
                        if (nums[r2 + 1] == midVal) {
                            r2++;
                        } else {
                            break;
                        }
                    }
                    return new int[]{l2, r2};
                }
                if (midVal < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return new int[]{-1, -1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}