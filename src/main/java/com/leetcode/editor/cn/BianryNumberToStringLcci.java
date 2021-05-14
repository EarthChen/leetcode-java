package com.leetcode.editor.cn;

//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 提示： 
//
// 
// 32位包括输出中的"0."这两位。 
// 
// Related Topics 字符串 
// 👍 22 👎 0


public class BianryNumberToStringLcci {
    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci().new Solution();
        System.out.println(solution.printBin(0.625));
        System.out.println(solution.printBin(0.1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            StringBuilder sb = new StringBuilder();
            sb.append("0.");
            num = num * 2;
            int intNum = (int) num;
            double decimalNum = num - (int) num;
            while (decimalNum != 0) {
                sb.append(intNum);
                num = decimalNum * 2;
                intNum = (int) num;
                decimalNum = num - (int) num;
            }
            sb.append(intNum);
            if (sb.length() > 32) {
                return "ERROR";
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}