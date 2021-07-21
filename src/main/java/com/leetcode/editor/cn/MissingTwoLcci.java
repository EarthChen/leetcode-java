package com.leetcode.editor.cn;

//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// Related Topics 位运算 数组 哈希表 
// 👍 42 👎 0


import java.util.Arrays;

public class MissingTwoLcci {
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();
        // int[] ans = solution.missingTwo(new int[]{1, 4});
        int[] ans = solution.missingTwo(new int[]{1, 3,5});
        // int[] ans = solution.missingTwo(new int[]{1});
        for (int an : ans) {
            System.out.println(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length + 2;
            int sum = (1 + length) * length / 2;
            int pre = 0;
            int first = -1;
            for (int num : nums) {
                sum -= num;
                if (num != pre + 1) {
                    if (first == -1) {
                        first = pre + 1;
                    }
                }
                pre = num;
            }
            if (first == -1) {
                first = pre + 1;
            }
            return new int[]{first, sum - first};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}