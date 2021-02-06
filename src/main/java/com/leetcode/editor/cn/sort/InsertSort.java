package com.leetcode.editor.cn.sort;

/**
 * @author earthchen
 * @date 2021/2/1
 **/
public class InsertSort {


    public void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                int current = nums[i];
                int index = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > current) {
                        nums[j + 1] = nums[j];
                        index = j;
                    } else {
                        nums[index] = current;
                        break;
                    }
                }
            }
        }
    }

    public void sort2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] nums = new int[]{1, 3, 4, 3, -1, 5};
        sort.sort2(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
