//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2602 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class PPermutations {
    public static void main(String[] args) {
        Solution solution = new PPermutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(solution.permute(nums));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            dfs(nums, new ArrayList<>(), 0);
            return ans;
        }

        private void dfs(int[] nums, List<Integer> res, int index) {
            if (res.size() == nums.length) {
                ans.add(new ArrayList<>(res));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (res.contains(nums[i])) {
                    continue;
                }
                res.add(nums[i]);
                dfs(nums, res, i + 1);
                res.remove(res.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}