package com.leetcode.editor.cn;

//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 298 👎 0


public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
        // System.out.println(solution.sum(12));
        // System.out.println(solution.movingCount(2,3,1));
        System.out.println(solution.movingCount(3,1,0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int count = 0;

        public int movingCount(int m, int n, int k) {
            int[][] grip = new int[m][n];
            dfs(grip, 0, 0, k);
            return count;
        }

        private void dfs(int[][] grip, int i, int j, int k) {
            if (i < 0 || i >= grip.length) {
                return;
            }
            if (j < 0 || j >= grip[0].length) {
                return;
            }
            if (sum(i) + sum(j) > k) {
                return;
            }
            if (grip[i][j] == 1) {
                return;
            }
            grip[i][j] = 1;
            count++;
            dfs(grip, i - 1, j, k);
            dfs(grip, i + 1, j, k);
            dfs(grip, i, j - 1, k);
            dfs(grip, i, j + 1, k);


        }

        private int sum(int x) {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x = x / 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}