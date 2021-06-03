package com.leetcode.editor.cn;

//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 深度优先搜索 广度优先搜索 数组 字符串 
// 👍 39 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordTransformerLcci {
    public static void main(String[] args) {
        Solution solution = new WordTransformerLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();//结果集
        List<String> wordList;//源字母列表
        String endWord;//结尾字母
        Set<String> vis = new HashSet<>();//标记字符是否被访问过

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            this.wordList = wordList;
            this.endWord = endWord;
            res.add(beginWord);
            vis.add(beginWord);
            return dfs(beginWord) ? res : new ArrayList<>();
        }

        public boolean dfs(String cur) {
            if (cur.equals(endWord)) {
                return true;
            }
            for (String next : wordList) {
                //是当前cur字母的候选字母 & 没有被访问过
                if (isNext(cur, next) && !vis.contains(next)) {
                    vis.add(next);//添加结果
                    res.add(next);
                    if (dfs(next)) {
                        return true;
                    } else {
                        res.remove(res.size() - 1);//该next不可选，移除
                    }
                }
            }
            return false;
        }

        public boolean isNext(String cur, String next) {
            int cnt = 0;
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != next.charAt(i)) {
                    cnt++;
                }
            }
            return cnt == 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}