//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1893 👎 0


package com.leetcode.editor.cn;

//Java：颜色分类
public class PSortColors {
    public static void main(String[] args) {
        Solution solution = new PSortColors().new Solution();
        int[] nums = new int[]{0,1,2};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            quickSort(nums);
        }


        private void quickSort(int[] nums) {

            quickSort0(nums, 0, nums.length - 1);
        }


        private void quickSort0(int[] nums, int left, int right) {
            if (left >= right) {
                return;
            }
            int piv = nums[left];
            int l = left;
            int r = right;
            int i = l + 1;
            while (i <= r) {
                int val = nums[i];
                if (val == piv) {
                    i++;
                    continue;
                }
                if (val > piv) {
                    swap(nums, i, r);
                    r--;
                } else {
                    swap(nums, i, l);
                    i++;
                    l++;
                }
            }
            quickSort0(nums, left, l - 1);
            quickSort0(nums, r + 1, right);
        }


        private void swap(int[] nums, int l, int r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}