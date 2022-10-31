//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1967 👎 0


package com.leetcode.editor.cn;

//Java：岛屿数量
public class P200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int numIslands(char[][] grid) {
            int len = grid.length;
            int width = grid[0].length;
            int count = 0;
            boolean[][] visited = new boolean[len][width];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < width; j++) {
                    if (visited[i][j]) {
                        continue;
                    }
                    char chr = grid[i][j];
                    if (chr == '1') {
                        count++;
                        dfs(grid, i, j, visited);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
            int len = grid.length;
            int width = grid[0].length;
            if (i < 0 || i >= len) {
                return;
            }
            if (j < 0 || j >= width) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            if (visited[i][j]) {
                return;
            }
            visited[i][j] = true;
            dfs(grid, i, j + 1, visited);
            dfs(grid, i, j - 1, visited);
            dfs(grid, i + 1, j, visited);
            dfs(grid, i - 1, j, visited);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}