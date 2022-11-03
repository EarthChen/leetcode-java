//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
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
// Related Topics 数组 哈希表 前缀和 👍 1725 👎 0


package com.leetcode.editor.cn;

//Java：和为 K 的子数组
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int[] sums = new int[len];
            sums[0] = nums[0];
            for (int i = 1; i < len; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
            int count = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    int cur = 0;
                    if (i == j) {
                        cur = nums[i];
                    } else if (j == 0) {
                        cur = sums[i];
                    } else {
                        cur = sums[i] - sums[j - 1];
                    }
                    if (cur == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}