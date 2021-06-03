package com.leetcode.editor.cn;

//设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。 
//
// 示例 1: 
//
// 输入: nums = [5,6,5], target = 11
//输出: [[5,6]] 
//
// 示例 2: 
//
// 输入: nums = [5,6,5,6], target = 11
//输出: [[5,6],[5,6]] 
//
// 提示： 
//
// 
// nums.length <= 100000 
// 
// Related Topics 数组 哈希表 
// 👍 24 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSumLcci {
    public static void main(String[] args) {
        Solution solution = new PairsWithSumLcci().new Solution();
        System.out.println(solution.pairSums(new int[]{
                6, 1, 7, 6, 5, 1, 0, 0, 5, -1
        }, 6));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pairSums(int[] nums, int target) {
            int length = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int i = 0;
            int j = length - 1;
            while (i < j) {
                int num1 = nums[i];
                int num2 = nums[j];
                int sum = num1 + num2;
                if (sum == target) {
                    res.add(Arrays.asList(num1, num2));
                    i++;
                    j--;
                    continue;
                }
                if (sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return res;
            // List<List<Integer>> res = new ArrayList<>();
            // Map<Integer, Integer> map = new HashMap<>();
            // for (int num : nums) {
            //     map.put(num, map.getOrDefault(num, 0) + 1);
            // }
            // for (int num1 : map.keySet()) {
            //     int num2 = target - num1;
            //     if (map.containsKey(num2) && map.get(num2) > 0) {
            //         int count = 0;
            //         if (num1 == num2) {
            //             count = map.get(num1) / 2;
            //         } else {
            //             count = Math.min(map.get(num1), map.get(num2));
            //         }
            //         for (int i = 0; i < count; i++) {
            //             res.add(Arrays.asList(num1, num2));
            //         }
            //         map.put(num1, 0);
            //         map.put(num2, 0);
            //     }
            // }
            // return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}