package com.leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。 
//
// 注意：此题 matrix 输入格式为一维 01 字符串数组。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = ["10100","10111","11111","10010"]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = ["0"]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = ["1"]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = ["00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// 
//
// 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-rectangle/
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 9 👎 0


import java.util.LinkedList;

public class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            int length = matrix.length;
            if (length == 0) {
                return 0;
            }
            int width = matrix[0].length();

            int[] height = new int[width];
            int max = 0;
            for (String str : matrix) {
                for (int i = 0; i < width; i++) {
                    if (str.charAt(i) == '1') {
                        height[i] += 1;
                    } else {
                        height[i] = 0;
                    }
                }
                max = Math.max(max, max(height));
            }
            return max;
        }

        private int max(int[] height) {
            int length = height.length;
            int[] left = new int[length];
            int[] right = new int[length];
            LinkedList<Integer> stack = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
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
                while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    right[i] = length;
                } else {
                    right[i] = stack.peek();
                }
                stack.push(i);
            }
            int max = 0;
            for (int i = 0; i < length; i++) {
                max = Math.max((right[i] - left[i] - 1) * height[i], max);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}