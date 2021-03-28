package com.leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1249 👎 0


import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums,new ArrayList<>());
            return ret;
        }

        private void backtrack(int[] nums, List<Integer> subRet) {
            if (nums.length == subRet.size()) {
                ret.add(new ArrayList<>(subRet));
                return;
            }
            for (int num : nums) {
                if (subRet.contains(num)) {
                    continue;
                }
                subRet.add(num);
                backtrack(nums, subRet);
                subRet.remove(subRet.size() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}