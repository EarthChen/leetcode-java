package com.leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
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
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2130 👎 0


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * @param s
         * @return
         */
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            if (s.length() % 2 == 1) {
                return false;
            }
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (map.containsKey(currentChar)) {
                    // 当是右括号时判断和栈头的是否相等
                    if (stack.isEmpty() || !stack.peek().equals(map.get(currentChar))) {
                        return false;
                    }
                    stack.pop();
                } else {
                    // 当是左括号时放入栈
                    stack.push(currentChar);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}