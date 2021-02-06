package com.leetcode.editor.cn.sort;

/**
 * @author earthchen
 * @date 2021/1/31
 **/
public class QuackSort {

    public void quackSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // int m = part2(nums, left, right);
        int m = part3(nums, left, right);
        quackSort(nums, left, m - 1);
        quackSort(nums, m + 1, right);
    }

    public void quackSort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int v = nums[left];
        int l = left;
        int r = right;
        int i = left + 1;
        while (i <= r) {
            if (nums[i] == v) {
                i++;
            } else if (nums[i] < v) {
                swap(nums, i, l);
                i++;
                l++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
        quackSort2(nums, left, l - 1);
        quackSort2(nums, r + 1, right);
    }

    /**
     * 两路快排
     * <p>
     * 必须先处理右指针
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int part2(int[] nums, int left, int right) {
        int part = nums[left];
        int lp = left;
        int rp = right;
        while (lp < rp) {
            while (nums[rp] >= part && lp < rp) {
                rp--;
            }
            while (nums[lp] <= part && lp < rp) {
                lp++;
            }
            swap(nums, lp, rp);
        }
        swap(nums, lp, left);
        return lp;
    }


    /**
     * 三路快排
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int part3(int[] nums, int left, int right) {
        int part = nums[left];
        int lp = left;
        int rp = right;
        int i = left;
        while (i < rp) {
            if (nums[i] < part) {
                swap(nums, lp + 1, i);
                i++;
                lp++;
            } else if (nums[i] > part) {
                swap(nums, rp, i);
                rp--;
            } else {
                i++;
            }
        }
        swap(nums, lp, left);
        return lp;
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        QuackSort quackSort = new QuackSort();
        // int[] nums = new int[]{5,1, 3, 5, 2, 10, -1, 5, 4, 5};
        int[] nums = new int[]{4, 3, 1, 4, 1, 5};
        quackSort.quackSort2(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
