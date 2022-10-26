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
//
// Related Topics 位运算 数组 回溯 👍 1834 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        int[] nums = new int[]{1, 2, 3};
        Object obj = solution.subsets(nums);
        System.out.println(obj);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        List<List<Integer>> ret = new ArrayList<>();


        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0, new ArrayList<>());
            return ret;
        }


        private void dfs(int[] nums, int index, List<Integer> curRet) {
            ret.add(new ArrayList<>(curRet));
            for (int i = index; i < nums.length; i++) {
                curRet.add(nums[i]);
                dfs(nums, i + 1, curRet);
                curRet.remove(curRet.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}