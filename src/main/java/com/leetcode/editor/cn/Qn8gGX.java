package com.leetcode.editor.cn;

//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//    [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
//
// 
//
// 注意：本题与主站 373 题相同：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-
//sums/ 
// Related Topics 数组 堆（优先队列） 👍 3 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Qn8gGX {
    public static void main(String[] args) {
        Solution solution = new Qn8gGX().new Solution();
        // System.out.println(solution.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(solution.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ret = new ArrayList<>();

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
            for (int value : nums1) {
                for (int i : nums2) {
                    minheap.offer(new int[]{value, i});
                }
            }
            int i = 0;
            List<List<Integer>> list = new ArrayList<>();
            while (minheap.size() > 0 && i < k) {
                List<Integer> temp = new ArrayList<>();
                int[] temp_arr = minheap.poll();
                temp.add(temp_arr[0]);
                temp.add(temp_arr[1]);
                list.add(temp);
                i++;
            }
            return list;
        }
        // Queue<int[]> minHeap = new PriorityQueue<>((p1, p2)
        //         -> nums1[p1[0]] + nums2[p1[1]] - nums1[p2[0]] - nums2[p2[1]]);
        // if (nums2.length > 0) {
        //     for (int i = 0; i < Math.min(k, nums1.length); ++i) {
        //         minHeap.offer(new int[]{i, 0});
        //     }
        // }
        //
        // List<List<Integer>> result = new ArrayList<>();
        // while (k-- > 0 && !minHeap.isEmpty()) {
        //     int[] ids = minHeap.poll();
        //     result.add(Arrays.asList(nums1[ids[0]], nums2[ids[1]]));
        //
        //     if (ids[1] < nums2.length - 1) {
        //         minHeap.offer(new int[]{ids[0], ids[1] + 1});
        //     }
        // }
        //
        // return result;
    }
//leetcode submit region end(Prohibit modification and deletion)

}