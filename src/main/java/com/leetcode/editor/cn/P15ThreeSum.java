//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 5294 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        // int[] nums = new int[]{0,0,0,0};
        // int[] nums = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> result = solution.threeSum(nums);


        System.out.println(result);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int len = nums.length;
            int maxLen = len - 2;
            for (int i = 0; i < maxLen; i++) {
                if (i > 0) {
                    if (nums[i] == nums[i - 1]) {
                        continue;
                    }
                }
                int cur = nums[i];
                int target = -cur;
                int l = i + 1;
                int r = len - 1;
                while (l < r) {
                    int curSum = nums[l] + nums[r];
                    if (curSum == target) {
                        if (l > i + 1) {
                            if (nums[l] == nums[l - 1]) {
                                l++;
                                continue;
                            }
                        }
                        List<Integer> curResult = new ArrayList<>();
                        curResult.add(cur);
                        curResult.add(nums[l]);
                        curResult.add(nums[r]);
                        result.add(curResult);
                        l++;
                        r--;
                        continue;
                    }
                    if (curSum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return result;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}