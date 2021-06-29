package com.leetcode.editor.cn;

//假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。 
//
// 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。 
//
// 示例 1: 
//
// 输入:
//big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
//small = [1,5,9]
//输出: [7,10] 
//
// 示例 2: 
//
// 输入:
//big = [1,2,3]
//small = [4]
//输出: [] 
//
// 提示： 
//
// 
// big.length <= 100000 
// 1 <= small.length <= 100000 
// 
// Related Topics 数组 哈希表 滑动窗口 
// 👍 30 👎 0


import java.util.HashMap;
import java.util.Map;

public class ShortestSupersequenceLcci {
    public static void main(String[] args) {
        Solution solution = new ShortestSupersequenceLcci().new Solution();
        int[] ans = solution.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}, new int[]{1, 5
                , 9});
        for (int an : ans) {
            System.out.println(an);
        }

        ans = solution.shortestSeq(new int[]{1, 2, 3, 4}, new int[]{2, 4});
        for (int an : ans) {
            System.out.println(an);
        }

        ans = solution.shortestSeq(new int[]{878982, 143504, 268583, 394343, 849567, 257687, 352256, 35131, 663529, 543027}, new int[]{143504});
        for (int an : ans) {
            System.out.println(an);
        }

        ans = solution.shortestSeq(new int[]{842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179,
                565,
                740, 672, 624, 130, 555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614,
                885, 836
                , 842, 505, 187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434,
                540,
                284, 567, 821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387,
                632, 898
                , 297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825,
                277, 138,
                778, 851, 732, 176}, new int[]{950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174
                , 210,
                287, 672, 994, 614, 732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887
                , 272,
                995, 121, 225, 112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297
                , 179,
                277, 304});
        for (int an : ans) {
            System.out.println(an);
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            int smallLength = small.length;
            int bigLength = big.length;
            if (smallLength > bigLength) {
                return new int[]{};
            }
            int success = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : small) {
                Integer count = map.get(i);
                if (count == null) {
                    success++;
                    count = 0;
                }
                map.put(i, count + 1);
            }
            int fast = 0;
            int slow = 0;
            int min = Integer.MAX_VALUE;
            int[] ans = new int[]{};
            while (fast < bigLength) {
                int curNum = big[fast];
                Integer count = map.get(curNum);
                if (count == null) {
                    fast++;
                    continue;
                }
                count--;
                if (count == 0) {
                    success--;
                }
                map.put(curNum, count);

                if (success == 0) {
                    while (slow < fast) {
                        Integer slowCount = map.get(big[slow]);
                        if (slowCount == null) {
                            slow++;
                        } else if (slowCount < 0) {
                            slowCount++;
                            map.put(big[slow], slowCount);
                            slow++;
                        } else {
                            break;
                        }
                    }
                    int curMin = fast  - slow;
                    if (curMin < min) {
                        ans = new int[]{slow, fast};
                        min = curMin;
                    }
                    fast++;
                    continue;
                }
                fast++;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}