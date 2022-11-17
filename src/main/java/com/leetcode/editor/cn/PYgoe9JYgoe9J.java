//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
//
// 
//
// 
// 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/ 
//
// Related Topics 数组 回溯 👍 37 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：允许重复选择元素的组合
public class PYgoe9JYgoe9J {
    public static void main(String[] args) {
        Solution solution = new PYgoe9JYgoe9J().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        List<List<Integer>> ret = new ArrayList<>();


        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(candidates, 0, target, new ArrayList<>());
            return ret;
        }

        private void dfs(int[] candidates, int index, int target, List<Integer> cur) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ret.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                int candidate = candidates[i];
                cur.add(candidate);
                dfs(candidates, i, target - candidate, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}