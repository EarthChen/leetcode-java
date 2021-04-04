package com.leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1114 👎 0


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        System.out.println(solution.subsets(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ret = new ArrayList<>();


        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, new ArrayList<>(), 0);
            return ret;
        }

        private void backtrack(int[] nums, List<Integer> path, int i) {
            ret.add(new ArrayList<>(path));
            for (int j = i; j < nums.length; j++) {
                path.add(nums[j]);
                backtrack(nums, path, j + 1);
                path.remove(path.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}