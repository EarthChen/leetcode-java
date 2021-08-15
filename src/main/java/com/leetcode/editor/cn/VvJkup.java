package com.leetcode.editor.cn;

//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
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
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 
// 👍 1 👎 0


import java.util.ArrayList;
import java.util.List;

public class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            dfs(nums, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] nums, List<Integer> set) {
            if (set.size() == nums.length) {
                ans.add(new ArrayList<>(set));
                return;
            }
            for (int num : nums) {
                if (set.contains(num)) {
                    continue;
                }
                set.add(num);
                dfs(nums, set);
                set.remove(set.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}