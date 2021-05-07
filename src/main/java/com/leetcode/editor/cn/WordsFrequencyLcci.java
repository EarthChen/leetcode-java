package com.leetcode.editor.cn;

//设计一个方法，找出任意指定单词在一本书中的出现频率。 
//
// 你的实现应该支持如下操作： 
//
// 
// WordsFrequency(book)构造函数，参数为字符串数组构成的一本书 
// get(word)查询指定单词在书中出现的频率 
// 
//
// 示例： 
//
// WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple
//", "he", "have", "a", "pen"});
//wordsFrequency.get("you"); //返回0，"you"没有出现过
//wordsFrequency.get("have"); //返回2，"have"出现2次
//wordsFrequency.get("an"); //返回1
//wordsFrequency.get("apple"); //返回1
//wordsFrequency.get("pen"); //返回1
// 
//
// 提示： 
//
// 
// book[i]中只包含小写字母 
// 1 <= book.length <= 100000 
// 1 <= book[i].length <= 10 
// get函数的调用次数不会超过100000 
// 
// Related Topics 设计 哈希表 
// 👍 19 👎 0


import java.util.HashMap;
import java.util.Map;

public class WordsFrequencyLcci {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordsFrequency {

        private Map<String, Integer> map = new HashMap<>();

        public WordsFrequency(String[] book) {
            for (String s : book) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word,0);
        }
    }

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}