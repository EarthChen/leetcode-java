package com.leetcode.editor.cn;

//给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。 
//
// 示例 1： 
//
// 输入: num = 1775(110111011112)
//输出: 8
// 
//
// 示例 2： 
//
// 输入: num = 7(01112)
//输出: 4
// 
// Related Topics 位运算 动态规划 
// 👍 40 👎 0


public class ReverseBitsLcci {
    public static void main(String[] args) {
        Solution solution = new ReverseBitsLcci().new Solution();
        System.out.println(solution.reverseBits(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverseBits(int num) {
            int ans = 0;
            int cur = 0; // 当前连续1 （最多外加一个0）的长度
            int lastZero = -1; // 上一0出现的位置， 设最左边的位置为0

            for (int i = 0; i < 32; i++) {
                int bit = num & (1 << (31 - i));
                if (bit != 0) {
                    cur++; // 当前数位1，总是增加连续1的长度
                } else {
                    cur = i - lastZero; // 当前数位0，则截掉lastZero之前，即只保留lastZero之后到i的长度
                    lastZero = i;
                }
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}