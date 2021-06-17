package com.leetcode.editor.cn;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 338 👎 0


public class Qiu12nLcof {
    public static void main(String[] args) {
        Solution solution = new Qiu12nLcof().new Solution();
        System.out.println(solution.sumNums(3));
        System.out.println(solution.sumNums(9));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int sumNums(int n) {
            boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
            return n;
        }

        // public int sumNums(int n) {
        //     return (n + (int) Math.pow(n, 2)) >> 1;
        // }
    }
//leetcode submit region end(Prohibit modification and deletion)

}