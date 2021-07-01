package com.leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 单调栈 
// 👍 1415 👎 0


import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int length = heights.length;
            int[] left = new int[length];
            int[] right = new int[length];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    left[i] = -1;
                } else {
                    left[i] = stack.peek();
                }
                stack.push(i);
            }
            stack.clear();
            for (int i = length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    right[i] = length;
                } else {
                    right[i] = stack.peek();
                }
                stack.push(i);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < length; i++) {
                max = Math.max((right[i] - left[i]-1) * heights[i], max);
            }
            return max;

            // 存最小高度
            // int[] dp = new int[length];
            // int max = Integer.MIN_VALUE;
            // for (int i = 0; i < length; i++) {
            //     for (int j = i; j < length; j++) {
            //         if (i == j) {
            //             dp[j] = heights[i];
            //             max = Math.max(max, heights[i]);
            //             continue;
            //         }
            //         dp[j] = Math.min(heights[j], dp[j - 1]);
            //         max = Math.max(max, (j + 1 - i) * dp[j]);
            //     }
            // }
            // return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}