package com.leetcode.editor.cn;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 62 👎 0


import java.util.Arrays;

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
        int[] ans = solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for (int an : ans) {
            System.out.print(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            Arrays.sort(arr);
            int[] ans = new int[k];
            System.arraycopy(arr, 0, ans, 0, k);
            return ans;

            //     PriorityQueue<Integer> deap = new PriorityQueue<>((a, b) -> b - a);
            //     for (int i : arr) {
            //         deap.offer(i);
            //         if (deap.size() > k) {
            //             deap.poll();
            //         }
            //     }
            //     int[] ans = new int[k];
            //     int i = 0;
            //     while (!deap.isEmpty()) {
            //         ans[i] = deap.poll();
            //         i++;
            //     }
            //     return ans;
            // }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}