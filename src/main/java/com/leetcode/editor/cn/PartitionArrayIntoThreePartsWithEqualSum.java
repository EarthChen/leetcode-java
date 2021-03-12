package com.leetcode.editor.cn;

//给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。 
//
// 形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + 
//A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。 
//
// 
//
// 示例 1： 
//
// 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
//输出：true
//解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
// 
//
// 示例 2： 
//
// 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[3,3,6,5,-2,2,5,1,-9,4]
//输出：true
//解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 50000 
// -10^4 <= A[i] <= 10^4 
// 
// Related Topics 数组 
// 👍 135 👎 0


public class PartitionArrayIntoThreePartsWithEqualSum {
    public static void main(String[] args) {
        Solution solution = new PartitionArrayIntoThreePartsWithEqualSum().new Solution();
        // System.out.println(solution.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        // System.out.println(solution.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        // System.out.println(solution.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
        System.out.println(solution.canThreePartsEqualSum(new int[]{18, 12, -18, 18, -19, -1, 10, 10}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canThreePartsEqualSum(int[] arr) {
            int s = 0;
            for (int num : arr) {
                s += num;
            }
            if (s % 3 != 0) {
                return false;
            }
            int target = s / 3;
            int n = arr.length, i = 0, cur = 0;
            while (i < n) {
                cur += arr[i];
                if (cur == target) {
                    break;
                }
                ++i;
            }
            if (cur != target) {
                return false;
            }
            int j = i + 1;
            while (j + 1 < n) {  // 需要满足最后一个数组非空
                cur += arr[j];
                if (cur == target * 2) {
                    return true;
                }
                ++j;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}