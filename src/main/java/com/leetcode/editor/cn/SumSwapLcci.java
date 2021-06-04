package com.leetcode.editor.cn;

//给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。 
//
// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
// 
//
// 示例: 
//
// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
//输出: [1, 3]
// 
//
// 示例: 
//
// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
//输出: [] 
//
// 提示： 
//
// 
// 1 <= array1.length, array2.length <= 100000 
// 
// Related Topics 排序 数组 
// 👍 24 👎 0


import java.util.Arrays;

public class SumSwapLcci {
    public static void main(String[] args) {
        Solution solution = new SumSwapLcci().new Solution();
        int[] ret = solution.findSwapValues(new int[]{519, 886, 282, 382, 662, 4718, 258, 719, 494, 795},
                new int[]{52, 20, 78, 50, 38, 96, 81, 20});

        // int[] ret = solution.findSwapValues(new int[]{4, 1, 2, 1, 1, 2},
        //         new int[]{3, 6, 3, 3});
        for (int i : ret) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findSwapValues(int[] array1, int[] array2) {
            Arrays.sort(array1);
            Arrays.sort(array2);
            int sum1 = sum(array1);
            int sum2 = sum(array2);
            if (sum1 >= sum2) {
                return find(array2, sum2, array1, sum1, true);
            } else {
                return find(array1, sum1, array2, sum2, false);
            }
        }

        private int sum(int[] array) {
            int sum1 = 0;
            for (int i : array) {
                sum1 += i;
            }
            return sum1;
        }

        /**
         * 假定 sum1 <sum2
         *
         * @param array1
         * @param sum1
         * @param array2
         * @param sum2
         * @return
         */
        private int[] find(int[] array1, int sum1, int[] array2, int sum2, boolean reverse) {
            int i = 0;
            int j = 0;
            while (i < array1.length && j < array2.length) {
                int left1 = sum1 - array1[i] + array2[j];
                int left2 = sum2 - array2[j] + array1[i];
                if (left1 == left2) {
                    if (reverse) {
                        return new int[]{array2[j], array1[i]};
                    }
                    return new int[]{array1[i], array2[j]};
                }
                if (left1 < left2) {
                    j++;
                } else {
                    i++;
                }
            }
            return new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}