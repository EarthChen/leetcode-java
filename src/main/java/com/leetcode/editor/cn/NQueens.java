package com.leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 856 👎 0


import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ret = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 下标为行 值为列
            back(0, new int[n]);
            return ret;
        }

        private void back(int row, int[] queue) {
            int n = queue.length;
            if (row >= n) {
                ret.add(getString(queue));
                return;
            }
            for (int col = 0; col < n; col++) {
                if (isOk(row, col, queue)) {
                    queue[row] = col;
                    back(row + 1, queue);
                }
            }
        }

        private List<String> getString(int[] queue) {
            int n = queue.length;
            List<String> curRet = new ArrayList<>();
            for (int column : queue) {
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j != column) {
                        str.append('.');
                    } else {
                        str.append('Q');
                    }
                }
                curRet.add(str.toString());
            }
            return curRet;
        }


        private boolean isOk(int row, int column, int[] queue) {
            int n = 1;
            for (int i = row - 1; i >= 0; i--) {
                if (queue[i] == column || queue[i] == column - n || queue[i] == column + n) {
                    return false;
                }
                n++;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}