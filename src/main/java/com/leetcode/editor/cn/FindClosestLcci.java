package com.leetcode.editor.cn;

//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 双指针 字符串 
// 👍 24 👎 0


public class FindClosestLcci {
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
        System.out.println(solution.findClosest(new String[]{
                "I", "am", "a", "student", "from", "a", "university", "in", "a", "city"
        }, "a", "student"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findClosest(String[] words, String word1, String word2) {
            boolean f1 = false, f2 = false;//标记是否都找到word1 和 word2
            int i1 = 0, i2 = 0;//分别记录word1和Word2的下标索引
            int dist = words.length;
            for (int i = 0; i < words.length; i++) {
                String cur = words[i];
                if (cur.equals(word1)) {
                    i1 = i;
                    f1 = true;
                } else if (cur.equals(word2)) {
                    i2 = i;
                    f2 = true;
                }
                if (f1 && f2) {//都找到了，更新dist
                    dist = Math.min(dist, Math.abs(i1 - i2));
                }
            }
            return dist;

            // Map<String, List<Integer>> wordIndexMap = new HashMap<>();
            // for (int i = 0; i < words.length; i++) {
            //     List<Integer> indexs = wordIndexMap.getOrDefault(words[i], new ArrayList<>());
            //     indexs.add(i);
            //     wordIndexMap.put(words[i], indexs);
            // }
            // List<Integer> empty = new ArrayList<>();
            // List<Integer> index1 = wordIndexMap.getOrDefault(word1, empty);
            // List<Integer> index2 = wordIndexMap.getOrDefault(word2, empty);
            // if (index1 == index2) {
            //     return 0;
            // }
            // int min = words.length;
            // for (Integer integer1 : index1) {
            //     for (Integer integer2 : index2) {
            //         min = Math.min(Math.abs(integer1 - integer2), min);
            //     }
            // }
            // return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}