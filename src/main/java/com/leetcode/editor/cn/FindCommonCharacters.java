package com.leetcode.editor.cn;

//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 204 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public static void main(String[] args) {
        Solution solution = new FindCommonCharacters().new Solution();
        System.out.println(solution.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            String first = A[0];
            int length = A.length - 1;
            List<Map<Character, Integer>> elseStringList = new ArrayList<>();
            for (int i = 1; i < A.length; i++) {
                String currentString = A[i];
                Map<Character, Integer> map = new HashMap<>(currentString.length());
                for (int j = 0; j < currentString.length(); j++) {
                    Integer num = map.get(currentString.charAt(j));
                    if (num == null) {
                        num = 0;
                    }
                    num++;
                    map.put(currentString.charAt(j), num);
                }
                elseStringList.add(map);
            }
            List<String> ret = new ArrayList<>();
            for (int i = 0; i < first.length(); i++) {
                char currentChar = first.charAt(i);
                for (int i1 = 0; i1 < elseStringList.size(); i1++) {
                    Map<Character, Integer> currentMap = elseStringList.get(i1);
                    Integer num = currentMap.get(currentChar);
                    if (num == null || num <= 0) {
                        break;
                    }
                    if (i1 == elseStringList.size() - 1) {
                        ret.add("" + currentChar);
                    }
                    num--;
                    currentMap.put(currentChar, num);
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}