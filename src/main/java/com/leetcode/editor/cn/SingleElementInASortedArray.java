package com.leetcode.editor.cn;

//给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
// Related Topics 数组 二分查找 👍 283 👎 0


public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution solution = new SingleElementInASortedArray().new Solution();
        System.out.println(solution.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans ^= nums[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}