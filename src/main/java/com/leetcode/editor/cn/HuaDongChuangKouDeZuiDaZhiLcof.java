package com.leetcode.editor.cn;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 277 👎 0


import java.util.Deque;
import java.util.LinkedList;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        int[] ans = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Deque<Integer> queue = new LinkedList<>();

        private Deque<Integer> maxQueue = new LinkedList<>();

        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            if (length == 0) {
                return new int[]{};
            }
            int[] ans = new int[length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                push_back(nums[i]);
                if (i == k - 1) {
                    ans[i - k + 1] = max_value();
                }
                if (i >= k) {
                    pop_front();
                    ans[i - k + 1] = max_value();
                }
            }
            return ans;
        }


        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.getFirst();
        }

        public void push_back(int value) {
            queue.addLast(value);
            while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
                maxQueue.pollLast();
            }
            maxQueue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int val = queue.pop();
            if (maxQueue.peek() == val) {
                maxQueue.pop();
            }
            return val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}