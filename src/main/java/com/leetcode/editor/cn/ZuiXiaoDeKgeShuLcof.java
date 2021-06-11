package com.leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 252 👎 0


import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        int[] a = solution.getLeastNumbers(new int[]{3, 2, 1, 4}, 2);

        for (int i : a) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {
                return new int[]{};
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
            for (int i : arr) {
                queue.add(i);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            int[] ans = new int[k];
            int i = 0;
            while (!queue.isEmpty()) {
                ans[i] = queue.poll();
                i++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}