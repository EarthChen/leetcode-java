package com.leetcode.editor.cn;

//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 
// 👍 76 👎 0


public class DuplicateZeros {
    public static void main(String[] args) {
        Solution solution = new DuplicateZeros().new Solution();
        int[] nums = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            int length = arr.length;
            int i = 0;
            while (i < length) {
                int cur = arr[i];
                if (cur == 0) {
                    if (i != length - 1) {
                        // int j = i + 2;
                        int j = length - 1;
                        while (j >= i + 2) {
                            arr[j] = arr[j - 1];
                            j--;
                        }
                        arr[i + 1] = 0;
                        i++;
                    }
                }
                i++;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}