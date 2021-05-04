package com.leetcode.editor.cn;

//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 字符串 动态规划 
// 👍 67 👎 0


public class OneAwayLcci {
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
        System.out.println(solution.oneEditAway("a", "b"));
        System.out.println(solution.oneEditAway("islander", "slander"));
        // System.out.println(solution.oneEditAway("pales","pal"));
        // System.out.println(solution.oneEditAway("pale","pal"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first.equals(second)) {
                return true;
            }
            int firstLength = first.length();
            int secondLength = second.length();

            if (Math.abs(firstLength - secondLength) > 1) {
                return false;
            }
            int i = 0;
            int j = 0;
            int count = 0;
            while (i < firstLength && j < secondLength) {
                char firstChar = first.charAt(i);
                char secondChar = second.charAt(j);
                i++;
                j++;
                if (firstChar == secondChar) {
                    continue;
                }
                count++;
                if (count > 1) {
                    return false;
                }
                if (firstLength > secondLength) {
                    j--;
                }
                if (secondLength > firstLength) {
                    i--;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}