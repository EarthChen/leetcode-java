package com.leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 767 👎 0


public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] pre = new int[nums.length];
            int[] end = new int[nums.length];
            pre[0] = 1;
            end[nums.length - 1] = 1;
            for (int i = 1; i < nums.length; i++) {
                pre[i] = pre[i - 1] * nums[i - 1];
            }
            for (int i = nums.length - 2; i >= 0; i--) {
                end[i] = end[i + 1] * nums[i + 1];
            }
            int[] ret = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ret[i] = pre[i] * end[i];
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}