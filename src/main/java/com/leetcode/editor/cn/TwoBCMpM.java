package com.leetcode.editor.cn;

//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// 
//
// 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 0 👎 0


import java.util.LinkedList;
import java.util.Queue;

public class TwoBCMpM {
    public static void main(String[] args) {
        Solution solution = new TwoBCMpM().new Solution();
        int[][] dp = solution.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        });

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] updateMatrix(int[][] matrix) {
            // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
            Queue<int[]> queue = new LinkedList<>();
            int m = matrix.length;
            int n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        matrix[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            // 为了一次处理四个方向 可以循环
            int[] dx = new int[]{-1, 1, 0, 0};
            int[] dy = new int[]{0, 0, -1, 1};
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];
                    // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                    // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                    if (newX >= 0
                            && newX < m
                            && newY >= 0
                            && newY < n
                            && matrix[newX][newY] == Integer.MAX_VALUE
                    ) {
                        matrix[newX][newY] = matrix[x][y] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}