package com.leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
//
// 
//
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
// Related Topics 数组 排序 
// 👍 0 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SsGoHC {
    public static void main(String[] args) {
        Solution solution = new SsGoHC().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int i = 0;
            while (i < intervals.length) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                // 如果有重叠，循环判断哪个起点满足条件
                while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                    i++;
                    right = Math.max(right, intervals[i][1]);
                }
                // 将现在的区间放进res里面
                res.add(new int[]{left, right});
                // 接着判断下一个区间
                i++;
            }
            return res.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}