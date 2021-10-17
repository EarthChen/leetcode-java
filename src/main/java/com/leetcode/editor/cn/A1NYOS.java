package com.leetcode.editor.cn;

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
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
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 👍 15 👎 0


import java.util.HashMap;
import java.util.Map;

public class A1NYOS {
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
        // System.out.println(solution.findMaxLength(new int[]{0,1,0}));
        // System.out.println(solution.findMaxLength(new int[]{0,1}));
        // System.out.println(solution.findMaxLength(new int[]{0, 1, 0, 1,1}));
        System.out.println(solution.findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            int maxLength = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int counter = 0;
            map.put(counter, -1);
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num == 1) {
                    counter++;
                } else {
                    counter--;
                }
                if (map.containsKey(counter)) {
                    int prevIndex = map.get(counter);
                    maxLength = Math.max(maxLength, i - prevIndex);
                } else {
                    map.put(counter, i);
                }
            }
            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}