package com.leetcode.editor.cn;

//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 132 👎 0


public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (target == nums[mid]) {
                    int n = 1;
                    for (int k = mid + 1; k < nums.length; k++) {
                        if (nums[k] == target) {
                            n++;
                        }else {
                            break;
                        }
                    }
                    for (int k = mid-1; k >=0; k--) {
                        if (nums[k] == target) {
                            n++;
                        }else {
                            break;
                        }
                    }
                    return n;
                }
                if (target > nums[mid]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}