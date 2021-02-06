package com.leetcode.editor.cn.sort;

/**
 * @author earthchen
 * @date 2021/2/1
 **/
public class MergeSort {

    public void mergeSort(int[] nums, int[] tmpNums, int left, int right) {
        // if (nums.length <= 1) {
        //     return;
        // }
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(nums, tmpNums, left, mid);
        mergeSort(nums, tmpNums, mid + 1, right);
        merge(nums, tmpNums, left, mid + 1, right);
    }


    private void merge(int[] nums, int[] tmpNums, int leftPos, int rightPos, int rightEnd) {
        // 保存左右边界
        int left = leftPos;
        int right = rightEnd;

        int leftEnd = rightPos - 1;
        int i = leftPos;
        // 左右范围同时存在
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (nums[leftPos] <= nums[rightPos]) {
                tmpNums[i] = nums[leftPos];
                i++;
                leftPos++;
            } else {
                tmpNums[i] = nums[rightPos];
                i++;
                rightPos++;
            }
        }
        // 只剩左边
        while (leftPos <= leftEnd) {
            tmpNums[i] = nums[leftPos];
            i++;
            leftPos++;
        }
        // 只剩右边
        while (rightPos <= rightEnd) {
            tmpNums[i] = nums[rightPos];
            i++;
            rightPos++;
        }
        for (int j = left; j <= right; j++) {
            nums[j] = tmpNums[j];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = new int[]{1, 4, 4, 5, 6, 5};
        int[] tmpNums = new int[nums.length];
        mergeSort.mergeSort(nums, tmpNums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
