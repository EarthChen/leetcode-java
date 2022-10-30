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
// Related Topics 数组 回溯 👍 2278 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ret = solution.permute(nums);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ret = new ArrayList<>();


        public List<List<Integer>> permute(int[] nums) {

            boolean[] visited = new boolean[nums.length];
            dfs(nums, visited, new ArrayList<>());
            return ret;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> curRet) {
            if (curRet.size() == nums.length) {
                ret.add(new ArrayList<>(curRet));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                curRet.add(nums[i]);
                dfs(nums, visited, curRet);
                visited[i] = false;
                curRet.remove(curRet.size() - 1);

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}