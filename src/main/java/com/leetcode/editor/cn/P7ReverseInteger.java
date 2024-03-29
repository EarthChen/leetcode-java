//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3702 👎 0


package com.leetcode.editor.cn;

//Java：整数反转
public class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        int x = -123;
        int ret = solution.reverse(x);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int ret = 0;
            int max = Integer.MAX_VALUE / 10;
            boolean flag = true;
            if (x < 0) {
                flag = false;
                x = -x;
            }
            while (x > 0) {
                if (ret > max) {
                    return 0;
                }
                int sign = x % 10;
                x = x / 10;
                ret = ret * 10 + sign;
            }
            return flag ? ret : -ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}