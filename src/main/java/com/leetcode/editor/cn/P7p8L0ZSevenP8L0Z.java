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
// 
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
//
// Related Topics 数组 回溯 👍 34 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：含有重复元素集合的全排列
public class P7p8L0ZSevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new P7p8L0ZSevenP8L0Z().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            dfs(nums, new boolean[nums.length], new ArrayList<>());
            return ret;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> cur) {
            if (cur.size() == nums.length) {
                ret.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (i > 0) {
                    if (nums[i] == nums[i - 1] && !visited[i-1]) {
                        continue;
                    }
                }
                visited[i] = true;
                cur.add(nums[i]);
                dfs(nums, visited, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}