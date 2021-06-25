package com.leetcode.editor.cn;

//在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。例如，在数组{5, 8, 4, 2, 3, 4, 6}中，{8
//, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。 
//
// 示例: 
//
// 输入: [5, 3, 1, 2, 3]
//输出: [5, 1, 3, 2, 3]
// 
//
// 提示： 
//
// 
// nums.length <= 10000 
// 
// Related Topics 贪心 数组 排序 
// 👍 31 👎 0


import java.util.Arrays;

public class PeaksAndValleysLcci {
    public static void main(String[] args) {
        Solution solution = new PeaksAndValleysLcci().new Solution();
        int[] ans = new int[]{5, 3, 1, 2, 3};
        solution.wiggleSort(ans);
        for (int an : ans) {
            System.out.print(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] a = Arrays.copyOf(nums, nums.length);
            Arrays.sort(a);
            int left = 0;
            int right = a.length - 1;
            int k = 0;
            boolean f = true;
            while (left <= right) {
                if (f) {
                    nums[k++] = a[right];
                    right--;
                    f = false;
                } else {
                    nums[k++] = a[left];
                    left++;
                    f = true;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}