package com.leetcode.editor.cn.struct;

public class PrintUtil {


    public static <T> void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + ",");
            } else {
                System.out.print(nums[i]);
            }
        }
    }

    public static <T> void print(int[][] nums) {
        for (int[] num : nums) {
            print(num);
            System.out.println();
        }
    }
}
