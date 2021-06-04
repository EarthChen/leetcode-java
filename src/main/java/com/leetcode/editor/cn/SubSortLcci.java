package com.leetcode.editor.cn;

//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 排序 数组 
// 👍 68 👎 0


public class SubSortLcci {
    public static void main(String[] args) {
        Solution solution = new SubSortLcci().new Solution();
        int[] ans = solution.subSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
        // int[] ans = solution.subSort(new int[]{1,3,5,7,9});
        for (int an : ans) {
            System.out.println(an);
        }
        // ans = solution.subSort(new int[]{0, -1});
        // for (int an : ans) {
        //     System.out.println(an);
        // }
        // ans = solution.subSort(new int[]{0, -1});
        // for (int an : ans) {
        //     System.out.println(an);
        // }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] subSort(int[] array) {
            if (array.length == 0) {
                return new int[]{-1, -1};
            }
            int max = array[0];

            int r = -1;
            for (int i = 1; i < array.length; i++) {

                if (array[i] >= max) {
                    max = array[i];
                } else {
                    r = i;
                }
            }

            int l = -1;
            int min = array[array.length - 1];
            for (int i = array.length - 1; i >= 0; i--) {

                if (array[i] <= min) {
                    min = array[i];
                } else {
                    l = i;
                }
            }

            return new int[]{l, r};
        }
        // int length = array.length;
        // if (length == 0 || length == 1) {
        //     return new int[]{-1, -1};
        // }
        // int[] array2 = new int[length];
        // System.arraycopy(array, 0, array2, 0, length);
        // Arrays.sort(array2);
        // int l = 0;
        // while (l < length) {
        //     if (array[l] != array2[l]) {
        //         break;
        //     }
        //     l++;
        // }
        // if (l == length) {
        //     return new int[]{-1, -1};
        // }
        // int r = length - 1;
        // while (r > l) {
        //     if (array[r] != array2[r]) {
        //         break;
        //     }
        //     r--;
        // }
        // return new int[]{l, r};
    }
    //leetcode submit region end(Prohibit modification and deletion)
}

}