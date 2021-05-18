package com.leetcode.editor.cn;

//给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差 
//
// 
//
// 示例： 
//
// 
//输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
//输出：3，即数值对(11, 8)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 100000 
// -2147483648 <= a[i], b[i] <= 2147483647 
// 正确结果在区间 [0, 2147483647] 内 
// 
// Related Topics 数组 双指针 
// 👍 35 👎 0


import java.util.Arrays;

public class SmallestDifferenceLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestDifferenceLcci().new Solution();
        System.out.println(solution.smallestDifference(
                new int[]{1, 3, 15, 11, 2},
                new int[]{23, 127, 235, 19, 8}
        ));
        System.out.println(solution.smallestDifference(
                new int[]{-2147483648, 1},
                new int[]{2147483647, 0}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDifference(int[] a, int[] b) {
            long min = Long.MAX_VALUE;
            Arrays.sort(b);
            Arrays.sort(a);
            int i = 0;
            int j = 0;
            while (i < a.length && j < b.length) {
                int aNum = a[i];
                int bNum = b[j];
                if (aNum == bNum) {
                    return 0;
                }
                if (aNum > bNum) {
                    j++;
                } else {
                    i++;
                }
                min = Math.min(min, Math.abs((long) aNum - (long) bNum));
            }
            // int abLength = a.length + b.length;
            // int[][] ab = new int[abLength][2];
            // int index = 0;
            // for (int i = 0; i < a.length; i++) {
            //     ab[index][0] = a[i];
            //     ab[index][1] = 1;
            //     index++;
            // }
            // for (int i = 0; i < b.length; i++) {
            //     ab[index][0] = b[i];
            //     ab[index][1] = 2;
            //     index++;
            // }
            //
            // Arrays.sort(ab, (o1, o2) -> (o1[0] - o2[0]));
            // for (int i = 1; i < abLength; i++) {
            //     int[] num2 = ab[i];
            //     int[] num1 = ab[i - 1];
            //     if (num1[1] != num2[1]) {
            //         min = Math.min(Math.abs(num2[0] - num1[0]), min);
            //     }
            // }
            return (int) min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}