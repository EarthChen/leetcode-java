package com.leetcode.editor.cn;

//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 64 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PondSizesLcci {
    public static void main(String[] args) {
        Solution solution = new PondSizesLcci().new Solution();
        int[] ans = solution.pondSizes(new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        });
        for (int an : ans) {
            System.out.println(an);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<Integer> ans = new ArrayList<>();

        private int size = 0;

        public int[] pondSizes(int[][] land) {
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] != 0) {
                        continue;
                    }
                    dfs(land, i, j);
                    if (size > 0) {
                        ans.add(size);
                    }
                    size = 0;
                }
            }
            Collections.sort(ans);
            int[] ret = new int[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                ret[i] = ans.get(i);
            }
            return ret;
        }

        private void dfs(int[][] land, int i, int j) {
            if (i < 0 || i >= land.length) {
                return;
            }
            if (j < 0 || j >= land[0].length) {
                return;
            }
            if (land[i][j] != 0) {
                return;
            }
            size++;
            land[i][j] = -1;
            dfs(land, i + 1, j);
            dfs(land, i, j + 1);
            dfs(land, i - 1, j);
            dfs(land, i, j - 1);
            dfs(land, i + 1, j + 1);
            dfs(land, i - 1, j - 1);
            dfs(land, i + 1, j - 1);
            dfs(land, i - 1, j + 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}