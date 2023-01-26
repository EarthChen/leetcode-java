package com.leetcode.editor.cn.sort;

import com.leetcode.editor.cn.struct.PrintUtil;

public class Sort {

    private static void quickSort3(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int part = arr[low];
        int l = low;
        int r = high;
        int i = low + 1;
        while (i <= r) {
            if (arr[i] == part) {
                i++;
            } else if (arr[i] > part) {
                swap(arr, r, i);
                r--;
            } else {
                l++;
                swap(arr, l, i);
                i++;
            }
        }
        swap(arr, low, l);
        quickSort3(arr, low, l - 1);
        quickSort3(arr, r + 1, high);
    }


    private static void mergeSort(int[] arr, int l, int r, int[] tmpArr) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid, tmpArr);
        mergeSort(arr, mid + 1, r, tmpArr);
        merge(arr, l, mid + 1, r, tmpArr);
    }

    private static void merge(int[] nums, int leftPos, int rightPos, int rightEnd, int[] tmpNums) {
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

    private static void swap(int[] arr, int l, int r) {
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 2, 3, 5, 6, 7, 9, 8};
        int[] tmpArr = new int[arr.length];
        PrintUtil.print(arr);
        mergeSort(arr, 0, arr.length - 1, tmpArr);
        // quickSort3(arr, 0, arr.length - 1);
        System.out.println();
        PrintUtil.print(arr);
    }
}
