//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
//
// Related Topics 数组 哈希表 前缀和 👍 106 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：0 和 1 个数相同的子数组
public class PA1NYOSA1NYOS {
    public static void main(String[] args) {
        Solution solution = new PA1NYOSA1NYOS().new Solution();
        int[] nums = new int[]{0, 1, 1, 0};
        int ret = solution.findMaxLength(nums);

        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int len = nums.length;
            int sum = 0;
            int maxLen = 0;
            Map<Integer, Integer> minL = new HashMap<>();
            minL.put(0, -1);
            int[] sums = new int[len];
            for (int i = 0; i < len; i++) {
                int curNum = nums[i];
                if (curNum == 0) {
                    sum++;
                } else {
                    sum--;
                }
                sums[i] = sum;
                int curMinL = minL.getOrDefault(sum, Integer.MAX_VALUE);
                curMinL = Math.min(curMinL, i);
                minL.put(sum, curMinL);
            }
            for (int i = 0; i < len; i++) {
                int l = minL.getOrDefault(sums[i], i + 1);
                maxLen = Math.max(maxLen, i - l);
            }
            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}