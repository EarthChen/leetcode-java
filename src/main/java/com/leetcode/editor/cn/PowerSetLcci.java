package com.leetcode.editor.cn;

//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 60 👎 0


import java.util.ArrayList;
import java.util.List;

public class PowerSetLcci {
    public static void main(String[] args) {
        Solution solution = new PowerSetLcci().new Solution();
        System.out.println(solution.subsets(new int[]{
                1, 2, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0, new ArrayList<>());
            return ans;
        }

        private void backtrack(int[] nums, int i, List<Integer> ret) {
            ans.add(new ArrayList<>(ret));
            for (int j = i; j < nums.length; j++) {
                ret.add(nums[j]);
                backtrack(nums, j + 1, ret);
                ret.remove(ret.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}