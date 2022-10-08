//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2139 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, String> numberMap = new HashMap<>();

        public Solution() {
            numberMap.put('2' , "abc");
            numberMap.put('3' , "def");
            numberMap.put('4' , "ghi");
            numberMap.put('5' , "jkl");
            numberMap.put('6' , "mno");
            numberMap.put('7' , "pqrs");
            numberMap.put('8' , "tuv");
            numberMap.put('9' , "wxyz");
        }

        List<String> result = new ArrayList<>();


        public List<String> letterCombinations(String digits) {
            int length = digits.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            dfs(digits, 0, new StringBuilder());
            return result;
        }

        public void dfs(String digits, int index, StringBuilder combination) {
            if (index == digits.length()) {
                result.add(combination.toString());
            } else {
                char digit = digits.charAt(index);
                String letters = numberMap.get(digit);
                int lettersCount = letters.length();
                for (int i = 0; i < lettersCount; i++) {
                    combination.append(letters.charAt(i));
                    dfs(digits, index + 1, combination);
                    combination.deleteCharAt(index);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}