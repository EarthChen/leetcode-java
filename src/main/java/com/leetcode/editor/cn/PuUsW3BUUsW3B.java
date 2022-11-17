//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
//
// Related Topics 数组 回溯 👍 36 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：含有 k 个元素的组合
public class PuUsW3BUUsW3B {
    public static void main(String[] args) {
        Solution solution = new PuUsW3BUUsW3B().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ret = new ArrayList<>();

        int k = 0;

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            dfs(n, 1, new ArrayList<>());
            return ret;
        }

        private void dfs(int n, int index, List<Integer> cur) {
            if (cur.size() == k) {
                ret.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i <= n; i++) {
                cur.add(i);
                dfs(n, i + 1, cur);
                cur.remove(cur.size() - 1);

            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}