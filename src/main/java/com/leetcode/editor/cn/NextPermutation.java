package com.leetcode.editor.cn;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1046 👎 0


public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int end = nums.length - 1;
            int start = 0;
            boolean find = false;
            for (int j = end; j > 0; j--) {
                if (nums[j - 1] < nums[j]) { //从后往前找到第一个升序的相邻数对，即nums[j-1]<nums[j]
                    for (int k = end; k > j - 1; k--) { //再从后往前找到第一个比nums[j-1]大的数，交换他们
                        if (nums[k] > nums[j - 1]) {
                            int temp = nums[j - 1];
                            nums[j - 1] = nums[k];
                            nums[k] = temp;
                            start = j; //交换的数的下一个位置，要保证之后升序排列
                            find = true;
                            break;
                        }
                    }
                }
                if (find) {
                    break;
                }
            }
            while (start <= end) { //刚刚的算法已经保证j~end是降序排列了，把它们弄成升序只需要头尾交换即可
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}