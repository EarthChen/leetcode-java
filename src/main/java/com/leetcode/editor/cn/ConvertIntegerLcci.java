package com.leetcode.editor.cn;

//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 29 👎 0


public class ConvertIntegerLcci {
    public static void main(String[] args) {
        Solution solution = new ConvertIntegerLcci().new Solution();
        System.out.println(solution.convertInteger(1, 2));
        System.out.println(solution.convertInteger(29, 15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int convertInteger(int A, int B) {
            int c = A ^ B;
            int count = 0;
            while (c != 0) {
                c = c & (c - 1);
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}