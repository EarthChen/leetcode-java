package com.leetcode.editor.cn;

//给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。 
//
// 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 
//最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//   [1,0,1],
//   [0,0,1],
//   [0,0,1]
//]
//输出: [1,0,2]
//解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
// 
//
// 示例 2: 
//
// 输入:
//[
//   [0,1,1],
//   [1,0,1],
//   [1,1,0]
//]
//输出: [0,0,1]
// 
//
// 提示： 
//
// 
// matrix.length == matrix[0].length <= 200 
// 
// Related Topics 动态规划 
// 👍 22 👎 0


public class MaxBlackSquareLcci {
    public static void main(String[] args) {
        Solution solution = new MaxBlackSquareLcci().new Solution();
        int[] ret = solution.findSquare(new int[][]{
                {1, 0, 1},
                {0, 0, 1},
                {0, 0, 1}
        });
        for (int i : ret) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 对于辅助数组right[][]大小与矩阵相同；如果 matrix[i][j]==1，直接 right[i][j]=0，否则
         * right[i][j]=矩阵元素matrix[i][j]右边连续0的数目（同一行）+1（加上自身）；down[i][j]与其类似，表示下边（同一列）0的数目。
         * 初始right[][]和down[][]完成后，遍历矩阵，对于元素为0的matrix[i][j],以(i,j)
         * 为左上角顶点的可能的最大正方形边长是right[i][j]和down[i][j]两者中的较小值，暂记在maxsize中。对于0,1,...,
         * maxsize中每一个可能的边长k，对应的正方形的上边和左边两条边均满足全为0，所以再判断右边和下边两条边即可:right[i+k][j]>k 和 down[i][j+k]>k。当前最长边长记录在retu[2]中
         *
         * @param matrix
         * @return
         */
        public int[] findSquare(int[][] matrix) {
            int size = matrix.length;
            int[] retu = new int[3];
            int[][] right = new int[size][size];
            int[][] down = new int[size][size];
            if (matrix[size - 1][size - 1] == 0) {
                right[size - 1][size - 1] = 1;
                down[size - 1][size - 1] = 1;
            }
            for (int i = size - 2; i >= 0; i--) {
                if (matrix[i][size - 1] == 0) {
                    right[i][size - 1] = 1;
                    down[i][size - 1] = down[i + 1][size - 1] + 1;
                }
                if (matrix[size - 1][i] == 0) {
                    right[size - 1][i] = right[size - 1][i + 1] + 1;
                    down[size - 1][i] = 1;
                }
            }
            for (int i = size - 2; i >= 0; i--) {
                for (int j = size - 2; j >= 0; j--) {
                    if (matrix[i][j] == 0) {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = down[i + 1][j] + 1;
                    }
                }
            }
            for (int i = 0; i < size - retu[2]; i++) {
                for (int j = 0; j < size - retu[2]; j++) {
                    if (matrix[i][j] == 0) {
                        int maxsize = Math.min(right[i][j], down[i][j]);
                        for (int k = retu[2]; k < maxsize; k++) {
                            if (right[i + k][j] > k && down[i][j + k] > k) {
                                retu[0] = i;
                                retu[1] = j;
                                retu[2] = k + 1;
                            }
                        }
                    }
                }
            }
            if (retu[2] == 0) {
                return new int[0];
            }
            return retu;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}