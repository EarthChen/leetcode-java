package com.leetcode.editor.cn;

//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3643 👎 0


public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        double s = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int totalLength = nums1.length + nums2.length;
            if (totalLength == 0) {
                return 0f;
            }
            int[] allNums = new int[totalLength];
            for (int i = 0; i < nums1.length; i++) {
                allNums[i] = nums1[i];
            }
            for (int i = 0; i < nums2.length; i++) {
                allNums[i + nums1.length] = nums2[i];
            }
            int low = 0;
            int high = allNums.length - 1;
            mergeSort(allNums, low, high);
            if (allNums.length % 2 == 0) {
                int middle = allNums.length / 2;
                if (middle == 1) {
                    return (allNums[0] + allNums[1]) / 2.0;
                }
                return (allNums[middle - 1] + allNums[middle]) / 2.0;
            }
            return allNums[allNums.length / 2 + 1 - 1];
        }

        public void mergeSort(int[] a, int low, int high) {
            int mid = (low + high) / 2;
            if (low < high) {
                // 左边
                mergeSort(a, low, mid);
                // 右边
                mergeSort(a, mid + 1, high);
                // 左右归并
                merge(a, low, mid, high);
            }

        }


        public void merge(int[] a, int low, int mid, int high) {
            int[] temp = new int[high - low + 1];
            int i = low;// 左指针
            int j = mid + 1;// 右指针
            int k = 0;
            // 把较小的数先移到新数组中
            while (i <= mid && j <= high) {
                if (a[i] < a[j]) {
                    temp[k++] = a[i++];
                } else {
                    temp[k++] = a[j++];
                }
            }
            // 把左边剩余的数移入数组
            while (i <= mid) {
                temp[k++] = a[i++];
            }
            // 把右边边剩余的数移入数组
            while (j <= high) {
                temp[k++] = a[j++];
            }
            // 把新数组中的数覆盖nums数组
            if (temp.length >= 0) {
                System.arraycopy(temp, 0, a, low, temp.length);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}