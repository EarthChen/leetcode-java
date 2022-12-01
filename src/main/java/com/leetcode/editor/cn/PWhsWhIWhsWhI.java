//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 
// 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
//sequence/ 
//
// Related Topics 并查集 数组 哈希表 👍 54 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Java：最长连续序列
public class PWhsWhIWhsWhI {
    public static void main(String[] args) {
        Solution solution = new PWhsWhIWhsWhI().new Solution();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int ret = solution.longestConsecutive(nums);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            Map<Integer, Set<Integer>> numIndexMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                Set<Integer> indexSet = numIndexMap.getOrDefault(nums[i], new HashSet<>());
                indexSet.add(i);
                numIndexMap.put(nums[i], indexSet);
            }
            int longest = 0;
            Map<Integer, Integer> numLongestMap = new HashMap<>();
            for (int num : nums) {
                int curNum = num + 1;
                int curNumLongest = 1;
                while (true) {
                    Integer alreadyNumLongest = numLongestMap.get(curNum);
                    if (alreadyNumLongest != null) {
                        curNumLongest += alreadyNumLongest;
                        break;
                    }
                    if (!numIndexMap.getOrDefault(curNum, new HashSet<>()).isEmpty()) {
                        curNumLongest++;
                        curNum++;
                    } else {
                        break;
                    }
                }
                longest = Math.max(longest, curNumLongest);
                numLongestMap.put(num, curNumLongest);
            }
            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}