package com.leetcode.editor.cn;

//给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符
//合要求的单词则返回空字符串。 
//
// 示例： 
//
// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
// 
//
// 提示： 
//
// 
// 0 <= len(words) <= 200 
// 1 <= len(words[i]) <= 100 
// 
// Related Topics 字符串 
// 👍 22 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordLcci {
    public static void main(String[] args) {
        Solution solution = new LongestWordLcci().new Solution();
        System.out.println(solution.longestWord(new String[]{
                "cat","banana","dog","nana","walk","walker","dogwalker"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words, (o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o2.length(), o1.length());
                }
            });

            Set<String> set = new HashSet<>(Arrays.asList(words));
            for (String word : words) {
                set.remove(word);
                if (find(set, word)) {
                    return word;
                }
            }
            return "";
        }

        public boolean find(Set<String> set, String word) {
            if (word.length() == 0) {
                return true;
            }
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.substring(0, i + 1)) && find(set, word.substring(i + 1))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}