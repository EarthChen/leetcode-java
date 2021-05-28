package com.leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 157 👎 0


public class ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
        System.out.println(solution.myPow(2, 10));
        System.out.println(solution.myPow(2, 11));
        System.out.println(solution.myPow(2, -2));
        System.out.println(solution.myPow(2, -2147483648));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1.0f;
            }
            if (n < 0) {
                return 1 / (x * myPow(x, - (n + 1)));
            }
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            }
            return myPow(x, n - 1) * x;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}