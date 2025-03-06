//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2657 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：和为 K 的子数组
public class PSubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new PSubarraySumEqualsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {

            int ret = 0;
            int length = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0;

            for (int i = 0; i < length; i++) {
                preSum = preSum + nums[i];
                if (map.containsKey(preSum - k)) {
                    ret += map.get(preSum - k);
                }
                map.put(preSum ,map.getOrDefault(preSum, 0) + 1);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}