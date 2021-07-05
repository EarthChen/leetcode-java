package com.leetcode.editor.cn;

//给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 你可以假设所有输入数组都可以得到满足题目要求的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,1,1,6,4]
//输出：[1,6,1,5,1,4]
//解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3,2,2,3,1]
//输出：[2,3,1,3,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// 0 <= nums[i] <= 5000 
// 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果 
// 
//
// 
//
// 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 数组 分治 快速选择 排序 
// 👍 260 👎 0


import java.util.Arrays;

public class WiggleSortIi {
    public static void main(String[] args) {
        Solution solution = new WiggleSortIi().new Solution();
        int[] ans = new int[]{1, 5, 1, 1, 6, 4};
        // int[] ans = new int[]{1, 3, 2, 2, 3, 1};
        solution.wiggleSort(ans);

        for (int an : ans) {
            System.out.println(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] ans = new int[nums.length];
            System.arraycopy(nums, 0, ans, 0, nums.length);
            Arrays.sort(ans);
            int index = nums.length - 1;
            for (int i = 1; i < nums.length; i += 2) {
                nums[i] = ans[index--];
            }
            for (int i = 0; i < nums.length; i += 2) {
                nums[i] = ans[index--];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}