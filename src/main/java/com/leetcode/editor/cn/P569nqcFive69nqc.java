//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
//
// Related Topics 数组 数学 字符串 排序 👍 34 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：最小时间差
public class P569nqcFive69nqc {
    public static void main(String[] args) {
        Solution solution = new P569nqcFive69nqc().new Solution();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        int min = solution.findMinDifference(timePoints);
        System.out.println(min);
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int ans = Integer.MAX_VALUE;
            int t0Minutes = getMinutes(timePoints.get(0));
            int preMinutes = t0Minutes;
            for (int i = 1; i < timePoints.size(); ++i) {
                int minutes = getMinutes(timePoints.get(i));
                ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
                preMinutes = minutes;
            }
            ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
            return ans;
        }

        public int getMinutes(String t) {
            return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}