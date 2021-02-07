package com.leetcode.editor.cn;

//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 238 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];
                List<Integer> currentIndex = map.get(currentNum);
                if (currentIndex != null) {
                    for (Integer index : currentIndex) {
                        if (Math.abs(index - i) <= k) {
                            return true;
                        }
                    }
                    currentIndex.add(i);
                    map.put(currentNum, currentIndex);
                } else {
                    currentIndex = new ArrayList<>();
                    currentIndex.add(i);
                    map.put(currentNum, currentIndex);
                }
            }
            return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}