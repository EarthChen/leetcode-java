package com.leetcode.editor.cn;

//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 
//9，则该函数输出 2。 
//
// 
//
// 示例 1： 
//
// 
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
//
// 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/ 
// Related Topics 位运算 
// 👍 120 👎 0


public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
        // System.out.println(solution.hammingWeight(0b00000000000000000000000000001011));
        // System.out.println(solution.hammingWeight(0b11111111111111111111111111111101));
        System.out.println(Integer.parseUnsignedInt("11111111111111111111111111111101",2));
        System.out.println(Integer.toBinaryString(-3));
        // System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        // System.out.println("11111111111111111111111111111101");
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(i + "---" + Integer.toBinaryString(i));
        // }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while(n != 0) {
                res += n & 1;
                n >>>= 1;
            }
            return res;

            // String str = Integer.toBinaryString(n);
            // int count = 0;
            // for (int i = 0; i < str.length(); i++) {
            //     if (str.charAt(i) == '1') {
            //         count++;
            //     }
            // }
            // return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}