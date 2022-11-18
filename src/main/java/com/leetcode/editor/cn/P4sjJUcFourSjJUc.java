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
// 
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
//
// Related Topics 数组 回溯 👍 35 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：含有重复元素集合的组合
public class P4sjJUcFourSjJUc {
    public static void main(String[] args) {
        Solution solution = new P4sjJUcFourSjJUc().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates, 0, new ArrayList<>(), target);
            return ret;
        }

        private void dfs(int[] candidates, int index, List<Integer> cur, int target) {
            if (target == 0) {
                ret.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                if (i > index) {
                    if (candidates[i] == candidates[i - 1]) {
                        continue;
                    }
                }
                int curTarget = target - candidates[i];
                if (curTarget < 0) {
                    break;
                }
                cur.add(candidates[i]);
                dfs(candidates, i + 1, cur, target - candidates[i]);
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}