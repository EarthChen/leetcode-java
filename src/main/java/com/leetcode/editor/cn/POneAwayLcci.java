//字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//first = "pale"
//second = "ple"
//输出：True 
//
// 
//
// 示例 2： 
//
// 
//输入：
//first = "pales"
//second = "pal"
//输出：False
// 
//
// Related Topics 双指针 字符串 👍 264 👎 0


package com.leetcode.editor.cn;

//Java：一次编辑
public class POneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new POneAwayLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            int len1 = first.length();
            int len2 = second.length();
            if (Math.abs(len1 - len2) > 1) {
                return false;
            }
            int i1 = 0;
            int i2 = 0;
            int diff = 0;
            while (i1 < len1 && i2 < len2) {
                if (first.charAt(i1) == second.charAt(i2)) {
                    i1++;
                    i2++;
                    continue;
                }
                diff++;
                if (diff > 1) {
                    return false;
                }
                if (len1 == len2) {
                    i1++;
                    i2++;
                    continue;
                }
                if (len1 > len2) {
                    i1++;
                } else {
                    i2++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}