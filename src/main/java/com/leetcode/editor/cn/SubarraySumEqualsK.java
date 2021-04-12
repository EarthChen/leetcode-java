package com.leetcode.editor.cn;

//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 852 👎 0


import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // int length = nums.length;
            // int[] sums = new int[length + 1];
            // sums[0] = 0;
            // for (int i = 1; i <= length; i++) {
            //     sums[i] = sums[i - 1] + nums[i-1];
            // }
            // int count = 0;
            // for (int i = 0; i <= length; i++) {
            //     for (int j = i + 1; j <= length; j++) {
            //         int curSum = sums[j] - sums[i];
            //         if (curSum == k) {
            //             count++;
            //         }
            //     }
            // }
            // return count;

            //map中的数据都是0~i (i的范围为0到nums.length-1) 的子数组和
            // 那么pre-k就是 0~j(j<i)的子数组和,如果在map里找到pre-k
            // j~i的子数组的和就是k了

            int count = 0;
            int pre = 0;
            HashMap<Integer, Integer> mp = new HashMap<>();
            mp.put(0, 1);
            for (int num : nums) {
                pre += num;
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}