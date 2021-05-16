package com.leetcode.editor.cn;

//给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字
//符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。 
//
// 示例： 
//
// 输入：
//big = "mississippi"
//smalls = ["is","ppi","hi","sis","i","ssippi"]
//输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
// 
//
// 提示： 
//
// 
// 0 <= len(big) <= 1000 
// 0 <= len(smalls[i]) <= 1000 
// smalls的总字符数不会超过 100000。 
// 你可以认为smalls中没有重复字符串。 
// 所有出现的字符均为英文小写字母。 
// 
// Related Topics 字典树 字符串 
// 👍 23 👎 0


import java.util.ArrayList;
import java.util.List;

public class MultiSearchLcci {
    public static void main(String[] args) {
        Solution solution = new MultiSearchLcci().new Solution();
        // System.out.println(solution.multiSearch("mississippi", new String[]{
        //         "is", "ppi", "hi", "sis", "i", "ssippi"
        // }));

        System.out.println(solution.multiSearch("abc", new String[]{
                ""
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] multiSearch(String big, String[] smalls) {
            int length = smalls.length;
            int[][] ans = new int[length][1001];
            for (int i = 0; i < length; i++) {
                String curStr = smalls[i];
                if (curStr.equals("")) {
                    ans[i] = new int[0];
                } else {
                    ans[i] = indexOfAll(big, curStr);
                }
            }
            return ans;
        }

        private int[] indexOfAll(String big, String small) {
            List<Integer> ans = new ArrayList<>();
            int beignIndex = 0;
            int index = big.indexOf(small, beignIndex);
            while (index != -1) {
                ans.add(index);
                beignIndex = index + 1;
                index = big.indexOf(small, beignIndex);
            }
            int[] ret = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                ret[i] = ans.get(i);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}