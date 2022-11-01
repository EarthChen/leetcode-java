//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1373 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Java：前 K 个高频元素
public class P347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new P347TopKFrequentElements().new Solution();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int[] ret = solution.topKFrequent(nums, 2);
        PrintUtil.print(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                Integer val = map.getOrDefault(num, 0);
                val++;
                map.put(num, val);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.add(entry);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            int size = queue.size();
            int[] ret = new int[size];
            for (int i = 0; i < size; i++) {
                Map.Entry<Integer, Integer> entry = queue.poll();
                ret[i] = entry.getKey();
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}