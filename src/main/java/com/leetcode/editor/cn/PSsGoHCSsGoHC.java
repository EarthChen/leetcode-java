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
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// 
//
// 
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/ 
//
// Related Topics 数组 排序 👍 37 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
public class PSsGoHCSsGoHC {
    public static void main(String[] args) {
        Solution solution = new PSsGoHCSsGoHC().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
            List<int[]> ans = new ArrayList<>();
            for (int[] interval : intervals) {
                int left = interval[0];
                int right = interval[1];
                if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < left) {
                    ans.add(new int[]{left, right});
                } else {
                    ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}