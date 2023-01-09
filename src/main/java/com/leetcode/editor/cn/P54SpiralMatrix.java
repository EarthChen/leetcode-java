//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1282 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：螺旋矩阵
public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        List<Integer> ret = solution.spiralOrder(matrix);
        System.out.println(ret);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int len = matrix.length;
            int width = matrix[0].length;
            int l = 0;
            int r = width - 1;
            int top = 0;
            int down = len - 1;
            int count = len * width;
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                for (int i = l; i <= r && count > 0; i++) {
                    count--;
                    list.add(matrix[top][i]);
                }
                top++;
                for (int i = top; i <= down && count > 0; i++) {
                    count--;
                    list.add(matrix[i][r]);
                }
                r--;
                for (int i = r; i >= l && count > 0; i--) {
                    count--;
                    list.add(matrix[down][i]);
                }
                down--;
                for (int i = down; i >= top && count > 0; i--) {
                    count--;
                    list.add(matrix[i][l]);
                }
                l++;

            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}