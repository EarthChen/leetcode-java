package com.leetcode.editor.cn;

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
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 0 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Five69nqc {
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
        System.out.println(solution.findMinDifference(Arrays.asList("23:59","00:00")));
        System.out.println(solution.findMinDifference(Arrays.asList("00:00","23:59","00:00")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Integer> numList = timePoints
                    .stream()
                    .map(this::getNum)
                    .sorted()
                    .collect(Collectors.toList());
            int min = 24 * 60 + 1;
            for (int i = 1; i < numList.size(); i++) {
                min = Math.min(min, numList.get(i) - numList.get(i - 1));
            }
            min = Math.min(min, 24 * 60 - numList.get(numList.size() - 1) + numList.get(0));
            return min;
        }

        private int getNum(String time) {
            String[] hm = time.split(":");
            return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}