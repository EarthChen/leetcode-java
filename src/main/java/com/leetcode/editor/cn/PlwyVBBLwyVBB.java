//某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。 
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 
//false。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//输出：true
//解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。 
//
// 示例 2： 
//
// 
//输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//输出：false
//解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。 
//
// 示例 3： 
//
// 
//输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//输出：false
//解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅
//' 是空白字符，定义为比任何其他字符都小（更多信息）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 20 
// order.length == 26 
// 在 words[i] 和 order 中的所有字符都是英文小写字母。 
// 
//
// 
//
// 
// 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
//
// Related Topics 数组 哈希表 字符串 👍 33 👎 0


package com.leetcode.editor.cn;

import java.util.Arrays;

//Java：外星语言是否排序
public class PlwyVBBLwyVBB {
    public static void main(String[] args) {
        Solution solution = new PlwyVBBLwyVBB().new Solution();
        String[] words = new String[]{"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean success = solution.isAlienSorted(words, order);
        System.out.println(success);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] ord = new int[26];
            for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
            String[] clone = words.clone();
            Arrays.sort(clone, (a, b) -> {
                int n = a.length();
                int m = b.length();
                int i = 0;
                int j = 0;
                while (i < n && j < m) {
                    int c1 = a.charAt(i) - 'a';
                    int c2 = b.charAt(j) - 'a';
                    if (c1 != c2) {
                        return ord[c1] - ord[c2];
                    }
                    i++;
                    j++;
                }
                if (i < n) {
                    return 1;
                }
                if (j < m) {
                    return -1;
                }
                return 0;
            });
            int n = words.length;
            for (int i = 0; i < n; i++) {
                if (!clone[i].equals(words[i])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}