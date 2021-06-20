package com.leetcode.editor.cn;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 265 👎 0


public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[]{};
            }
            int top = 0;
            int down = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            int count = matrix.length * matrix[0].length;
            int[] ans = new int[count];
            int index = 0;
            while (index < count) {
                for (int i = left; i <= right && index < count; i++) {
                    ans[index] = matrix[top][i];
                    index++;
                }
                top++;
                for (int i = top; i <= down && index < count; i++) {
                    ans[index] = matrix[i][right];
                    index++;
                }
                right--;
                for (int i = right; i >= left && index < count; i--) {
                    ans[index] = matrix[down][i];
                    index++;
                }
                down--;
                for (int i = down; i >= top && index < count; i--) {
                    ans[index] = matrix[i][left];
                    index++;
                }
                left++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}