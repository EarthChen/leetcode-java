//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
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
// 
//
// 
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
//
// Related Topics 位运算 数组 回溯 👍 53 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：所有子集
public class PTVdhknTVdhkn {
    public static void main(String[] args) {
        Solution solution = new PTVdhknTVdhkn().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            dfs(nums, 0, new ArrayList<>());
            return ret;
        }

        private void dfs(int[] nums, int index, List<Integer> cur) {
            if (index > nums.length) {
                return;
            }
            ret.add(new ArrayList<>(cur));
            for (int i = index; i < nums.length; i++) {
                cur.add(nums[i]);
                dfs(nums, i + 1, cur);
                cur.remove(cur.size() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}