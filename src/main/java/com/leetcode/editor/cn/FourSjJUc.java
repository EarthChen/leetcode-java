package com.leetcode.editor.cn;

//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 
// 👍 0 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSjJUc {
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
        // System.out.println(solution.combinationSum2(new int[]{5},5));
        System.out.println(solution.combinationSum2(new int[]{2,5,2,1,2},5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, target, new ArrayList<>(), 0);
            return ans;
        }

        private void dfs(int[] candidates, int target, List<Integer> list, int pos) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = pos; i < candidates.length; i++) {
                if (i > pos && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                int curTarget = target - candidates[i];
                dfs(candidates, curTarget, list, i+1);
                list.remove(list.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}