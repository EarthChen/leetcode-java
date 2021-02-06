package com.leetcode.editor.cn;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 755 👎 0


public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
            // 1.当，p1>=0时，nums[p1],nums[p2]对比
            // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
            // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
            // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
            // 循环结束条件：p2<0

            int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[p3--] = nums1[p1--];
                } else {
                    nums1[p3--] = nums2[p2--];
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}