package com.leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 2922 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return list;
            }
            Arrays.sort(nums);
            // 有序 当一个值大于0  后续均大于0
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return list;
                }
                // 当前值等于上一个值 （去重）
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 左指针
                int left = i + 1;
                // 右指针 向前
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[i] + nums[right];
                    if (sum == 0) {
                        List<Integer> currentList = new ArrayList<>();
                        currentList.add(nums[left]);
                        currentList.add(nums[i]);
                        currentList.add(nums[right]);
                        list.add(currentList);
                        // 判断左指针的下一个值是否等于当前值
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 判断右指针的下一个值是否等于当前值
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}