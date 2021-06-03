package com.leetcode.editor.cn;

//数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。 
//
// 示例 1： 
//
// 输入：[1,2,5,9,5,9,5,5,5]
//输出：5 
//
// 
//
// 示例 2： 
//
// 输入：[3,2]
//输出：-1 
//
// 
//
// 示例 3： 
//
// 输入：[2,2,1,1,1,2,2]
//输出：2 
//
// 
//
// 说明： 
//你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？ 
// Related Topics 位运算 数组 分治算法 
// 👍 83 👎 0


import java.util.Arrays;

public class FindMajorityElementLcci {
    public static void main(String[] args) {
        Solution solution = new FindMajorityElementLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {


            //排序法
            Arrays.sort(nums);
            int length = nums.length;
            int mid = length / 2;
            int midNum = nums[mid];
            int count = 0;
            for (int num : nums) {
                if (num == midNum) {
                    if (count >= mid) {
                        return num;
                    }
                    count++;
                }
            }
            return -1;

            // hash 法
            // Map<Integer, Integer> map = new HashMap<>();
            // int length = nums.length;
            // int midLength = length / 2;
            // for (int num : nums) {
            //     Integer count = map.getOrDefault(num, 0);
            //     count++;
            //     if (count > midLength) {
            //         return num;
            //     }
            //     map.put(num,count);
            // }
            // return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}