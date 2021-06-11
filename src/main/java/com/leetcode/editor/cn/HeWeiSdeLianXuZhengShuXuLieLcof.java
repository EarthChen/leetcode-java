package com.leetcode.editor.cn;

//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 279 👎 0


import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        int[][] ans=solution.findContinuousSequence(9);

        System.out.println(ans);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            if (target <= 1) {
                return new int[][]{};
            }
            int i = 1;
            int sum = 1;
            int j = 2;
            List<int[]> ret = new ArrayList<>();
            while (j < target) {
                if (sum == target) {
                    int[] cur = new int[j - i];
                    for (int k = i; k < j; k++) {
                        cur[k - i] = k;
                    }
                    ret.add(cur);
                }
                if (sum < target) {
                    sum += j;
                    j++;
                } else {
                    sum -= i;
                    i++;
                }
            }
            return ret.toArray(new int[0][0]);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}