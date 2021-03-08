package com.leetcode.editor.cn;

//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。 
//
// 你可以返回满足此条件的任何数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 5000 
// 0 <= A[i] <= 5000 
// 
// Related Topics 数组 
// 👍 195 👎 0


public class SortArrayByParity {
    public static void main(String[] args) {
        Solution solution = new SortArrayByParity().new Solution();
        int[] ret = solution.sortArrayByParity(new int[]{3, 1, 2, 4});
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] A) {
            int[] ji = new int[A.length];
            int jii = 0;
            int[] ou = new int[A.length];
            int oui = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    ou[oui] = A[i];
                    oui++;
                } else {
                    ji[jii] = A[i];
                    jii++;
                }
            }
            for (int i = 0; i < jii; i++) {
                ou[oui] = ji[i];
                oui++;
            }
            return ou;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}