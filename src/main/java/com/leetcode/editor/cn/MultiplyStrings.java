package com.leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 654 👎 0


public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("25", "4"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            // 有乘数为0，输出0（避免最后输出的是"0000"这种），字符串的比较要用equals
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            int index1 = num1.length() - 1;
            String ans = "0";
            while (index1 >= 0) {
                StringBuilder sb = new StringBuilder();
                int carry = 0;
                for (int k = num1.length() - 1; k > index1; k--) {
                    sb.append(0);
                }
                int index2 = num2.length() - 1;
                while (index2 >= 0) {
                    int num1_Int = num1.charAt(index1) - '0';
                    int num2_Int = num2.charAt(index2) - '0';
                    int temp = (num1_Int * num2_Int) + carry;
                    carry = temp / 10;
                    sb.append(temp % 10);
                    index2--;
                }
                if (carry > 0) {
                    sb.append(carry);
                }
                ans = addStrings(ans, sb.reverse().toString());
                index1--;
            }
            return ans;
        }

        public String addStrings(String num1, String num2) {
            int index1 = num1.length() - 1;
            int index2 = num2.length() - 1;
            int carry = 0;
            StringBuilder sb2 = new StringBuilder();
            while (index1 >= 0 || index2 >= 0) {
                int num1_Int = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
                int num2_Int = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
                int temp = num1_Int + num2_Int + carry;
                carry = temp / 10;
                sb2.append(temp % 10);
                index1--;
                index2--;
            }
            if (carry > 0) {
                sb2.append(carry);
            }
            return sb2.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}