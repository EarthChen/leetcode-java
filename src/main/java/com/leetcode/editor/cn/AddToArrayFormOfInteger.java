package com.leetcode.editor.cn;

//对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。 
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1,2,0,0], K = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 输入：A = [2,7,4], K = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 输入：A = [2,1,5], K = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 示例 4： 
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
//输出：[1,0,0,0,0,0,0,0,0,0,0]
//解释：9999999999 + 1 = 10000000000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 0 <= A[i] <= 9 
// 0 <= K <= 10000 
// 如果 A.length > 1，那么 A[0] != 0 
// 
// Related Topics 数组 
// 👍 141 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public static void main(String[] args) {
        Solution solution = new AddToArrayFormOfInteger().new Solution();
        System.out.println(solution.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(solution.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9},1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> knums = new ArrayList<>();
            while (K > 0) {
                int num = K % 10;
                knums.add(num);
                K = K / 10;
            }
            List<Integer> ret = new ArrayList<>();
            int kLength = knums.size();
            int aLength = A.length;
            // int max = Math.max(kLength, aLength);
            int i = 0;
            int num = 0;
            while (i < kLength && i < aLength) {
                int k = knums.get(i);
                int a = A[aLength - i - 1];
                int sum = a + k + num;
                if (sum - 10 >= 0) {
                    ret.add(sum - 10);
                    num = 1;
                } else {
                    ret.add(sum);
                    num=0;
                }
                i++;
            }
            while (i < kLength) {
                int k = knums.get(i);
                int sum = k + num;
                if (sum - 10 >= 0) {
                    ret.add(sum-10);
                    num = 1;
                } else {
                    ret.add(sum);
                    num=0;

                }
                i++;
            }
            while (i < aLength) {
                int a = A[aLength - i - 1];
                int sum = a + num;
                if (sum - 10 >= 0) {
                    ret.add(0);
                    num = 1;
                } else {
                    ret.add(sum);
                    num=0;

                }
                i++;
            }
            if (num == 1) {
                ret.add(num);
            }
            Collections.reverse(ret);
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}