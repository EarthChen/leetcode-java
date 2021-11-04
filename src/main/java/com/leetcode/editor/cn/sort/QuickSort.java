package com.leetcode.editor.cn.sort;

/**
 * @author earthchen
 * @date 2021/1/31
 **/
public class QuickSort {

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

    public void quickSort3(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int v = nums[left];
        int i = left + 1;
        while (i <= r) {
            if (nums[i] > v) {
                swap(nums, i, r);
                r--;
            } else if (nums[i] < v) {
                swap(nums, i, l);
                l++;
                i++;
            } else {
                i++;
            }
        }
        quickSort2(nums, left, l - 1);
        quickSort2(nums, r + 1, right);
    }

    public void quickSort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int v = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= v) {
                r--;
            }
            while (l < r && nums[l] <= v) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, l, left);
        quickSort2(nums, left, l - 1);
        quickSort2(nums, r + 1, right);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        // int[] nums = new int[]{5,1, 3, 5, 2, 10, -1, 5, 4, 5};
        int[] nums = new int[]{4, 3, 1, 4, 1, 5};
        qk(nums);
        // quickSort.quackSort2(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    private static void qk(int[] arr) {
        qk(arr, 0, arr.length - 1);
    }

    private static void swap2(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void qk(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int part = arr[left];
        int lp = left;
        int rp = right;
        int i = left;
        while (i < rp) {
            if (arr[i] == part) {
                i++;
                continue;
            }
            if (arr[i] < part) {
                swap2(arr, lp + 1, i);
                lp++;
                i++;
            } else {
                swap2(arr, rp, i);
                rp--;
            }
        }
        swap2(arr, lp, left);
        qk(arr, left, lp);
        qk(arr, rp, right);
    }
}

