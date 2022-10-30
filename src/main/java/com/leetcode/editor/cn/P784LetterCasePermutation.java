//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 446 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Java：字母大小写全排列
public class P784LetterCasePermutation {
    public static void main(String[] args) {
        Solution solution = new P784LetterCasePermutation().new Solution();
        System.out.println(solution.letterCasePermutation("a1b2"));
        System.out.println(solution.letterCasePermutation("3z4"));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            int len = s.length();
            List<StringBuilder> ret = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char chr = s.charAt(i);
                if (chr >= 'a' && chr <= 'z') {
                    char chr2 = (char) (chr - 32);
                    int size = ret.size();
                    if (size == 0) {
                        ret.add(new StringBuilder().append(chr));
                        ret.add(new StringBuilder().append(chr2));
                    } else {
                        for (int j = 0; j < size; j++) {
                            StringBuilder sb = ret.get(j);
                            StringBuilder sb2 = new StringBuilder(sb).append(chr2);
                            sb.append(chr);
                            ret.add(sb2);
                        }
                    }
                } else if (chr >= 'A' && chr <= 'Z') {
                    char chr2 = (char) (chr + 32);
                    int size = ret.size();
                    if (size == 0) {
                        ret.add(new StringBuilder().append(chr));
                        ret.add(new StringBuilder().append(chr2));
                    } else {
                        for (int j = 0; j < size; j++) {
                            StringBuilder sb = ret.get(j);
                            StringBuilder sb2 = new StringBuilder(sb).append(chr2);
                            sb.append(chr);
                            ret.add(sb2);
                        }
                    }
                } else {
                    int size = ret.size();
                    if (size == 0) {
                        ret.add(new StringBuilder().append(chr));
                    } else {
                        for (StringBuilder sb : ret) {
                            sb.append(chr);
                        }
                    }
                }
            }
            return ret.stream().map(StringBuilder::toString).collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}