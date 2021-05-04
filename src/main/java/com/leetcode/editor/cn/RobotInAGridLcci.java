package com.leetcode.editor.cn;

//设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角
//移动到右下角的路径。 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
//解释: 
//输入中标粗的位置即为输出表示的路径，即
//0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角） 
//
// 说明：r 和 c 的值均不超过 100。 
// Related Topics 动态规划 
// 👍 54 👎 0


import java.util.ArrayList;
import java.util.List;

public class RobotInAGridLcci {
    public static void main(String[] args) {
        Solution solution = new RobotInAGridLcci().new Solution();
        System.out.println(solution.pathWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            int length = obstacleGrid.length;
            int width = obstacleGrid[0].length;
            List<List<Integer>>[][] dp = new List[length][width];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    int cur = obstacleGrid[i][j];
                    if (cur == 1) {
                        dp[i][j] = new ArrayList<>();
                        continue;
                    }
                    if (i == 0 && j == 0) {
                        List<List<Integer>> ret = new ArrayList<>();
                        List<Integer> preIndex = new ArrayList<>();
                        preIndex.add(i);
                        preIndex.add(j);
                        ret.add(preIndex);
                        dp[i][j] = ret;
                    } else if (i == 0) {
                        List<List<Integer>> prePath = dp[i][j - 1];
                        if (prePath.isEmpty()) {
                            dp[i][j] = new ArrayList<>();
                        } else {
                            extracted(dp, i, j, prePath);
                        }
                    } else if (j == 0) {
                        List<List<Integer>> prePath = dp[i - 1][j];
                        if (prePath.isEmpty()) {
                            dp[i][j] = new ArrayList<>();
                        } else {
                            extracted(dp, i, j, prePath);
                        }
                    } else {
                        List<List<Integer>> prePath1 = dp[i - 1][j];
                        List<List<Integer>> prePath2 = dp[i][j - 1];
                        if (prePath1.isEmpty() && prePath2.isEmpty()) {
                            dp[i][j] = new ArrayList<>();
                        } else if (!prePath1.isEmpty()) {
                            extracted(dp, i, j, prePath1);
                        } else {
                            extracted(dp, i, j, prePath2);
                        }
                    }
                }
            }
            return dp[length - 1][width - 1];
        }

        private void extracted(List<List<Integer>>[][] dp, int i, int j, List<List<Integer>> prePath1) {
            List<Integer> preIndex = new ArrayList<>();
            preIndex.add(i);
            preIndex.add(j);
            List<List<Integer>> ret = new ArrayList<>(prePath1);
            ret.add(preIndex);
            dp[i][j] = ret;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}