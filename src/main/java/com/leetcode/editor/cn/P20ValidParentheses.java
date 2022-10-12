//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3547 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Java：有效的括号
public class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        // TO TEST
        boolean ret=solution.isValid("()[]({}");
        System.out.println(ret);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, Character> map;

        public Solution() {
            map = new HashMap<>();
            map.put('}', '{');
            map.put(')', '(');
            map.put(']', '[');
        }

        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char chr = s.charAt(i);
                Character ret = map.get(chr);
                if (ret == null) {
                    stack.push(chr);
                } else {
                    if (stack.peekFirst() == ret) {
                        stack.pop();
                    } else {
                        stack.push(chr);
                    }
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}