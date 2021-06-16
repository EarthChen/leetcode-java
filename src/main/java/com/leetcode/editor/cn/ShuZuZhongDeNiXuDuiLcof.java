package com.leetcode.editor.cn;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// 👍 441 👎 0


public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int res = 0;

        public int reversePairs(int[] nums) {
            int length = nums.length;
            if (length < 2) {
                return 0;
            }
            int[] temp = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1, temp);
            return res;
        }

        /**
         * 归并排序(稳定)：时间：O(nlogn) ; 空间：O(n)
         *
         * @param a     需要进行排序的数组
         * @param left  要排序的区间左下标
         * @param right 要排序的区间右下标
         * @param temp  额外中间缓存的数组，初始化 int[] temp = new int[a.length];
         */
        public void mergeSort(int[] a, int left, int right, int[] temp) {
            if (left >= right) {
                return;
            }
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid, temp);
            mergeSort(a, mid + 1, right, temp);
            merge(a, left, mid, right, temp);
        }

        /**
         * merge方法：对数组a [left,mid](已经有序) 和 [mid+1,right](已经有序) 区间进行合并排序， 利用temp数组将[left,right]排好序，再将temp拷回到a中对应的位置
         */
        public void merge(int[] a, int left, int mid, int right, int[] temp) {
            int i = left;
            int j = mid + 1;
            int k = 0;
            while (i <= mid && j <= right) {
                if (a[i] <= a[j]) {
                    temp[k++] = a[i++];
                }
                //当a[i]>a[j]时，进行逆序对的统计，i处于[left,mid] , j处于[mid+1,right]
                else {
                    temp[k++] = a[j++];
                    res += mid - i + 1;//仅仅比归并排序多这一行代码
                }
            }
            while (i <= mid) {
                temp[k++] = a[i++];
            }
            while (j <= right) {
                temp[k++] = a[j++];
            }
            k = 0;
            while (left <= right) {
                a[left++] = temp[k++];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    // public int reversePairs(int[] nums) {
    //     int length = nums.length;
    //     if (length < 2) {
    //         return 0;
    //     }
    //     int[] dp = new int[length];
    //     dp[0] = 0;
    //     for (int i = 1; i < length; i++) {
    //         int curNum = nums[i];
    //         int count = dp[i - 1];
    //         for (int j = 0; j < i; j++) {
    //             if (nums[j] > curNum) {
    //                 count++;
    //             }
    //         }
    //         dp[i] = count;
    //     }
    //     return dp[length-1];
    // }
}

