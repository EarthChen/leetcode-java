package com.leetcode.editor.cn.sort;

/**
 * @author earthchen
 * @date 2021/2/1
 **/
public class ShellSort {

    public void sort(int[] nums) {
        int gap = nums.length / 2;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                int j = i;
                if (nums[j - gap] > nums[j]) {
                    swap(nums, j, j - gap);
                    j = j - gap;
                }
            }
            gap = gap / 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] nums = new int[]{1, 3, 5, 2, 10, -1, 5, 4};
        shellSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
