package com.leetcode.editor.cn;

//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 
// 👍 1 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            dfs(nums, new ArrayList<>(), new boolean[nums.length]);
            return ans;
        }

        private void dfs(int[] nums, List<Integer> list, boolean[] vis) {
            if (nums.length == list.size()) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) {
                    continue;
                }
                if (i > 0 && vis[i - 1] && nums[i] == nums[i - 1]) {
                    continue;
                }
                vis[i] = true;
                list.add(nums[i]);
                dfs(nums, list, vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}