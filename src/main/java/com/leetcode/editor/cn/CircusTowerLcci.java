package com.leetcode.editor.cn;

//有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请
//编写代码计算叠罗汉最多能叠几个人。 
//
// 示例： 
//
// 
//输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
//输出：6
//解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190) 
//
//
// 提示： 
//
// 
// height.length == weight.length <= 10000 
// 
// Related Topics 排序 二分查找 动态规划 
// 👍 66 👎 0


import java.util.Arrays;

public class CircusTowerLcci {
    public static void main(String[] args) {
        Solution solution = new CircusTowerLcci().new Solution();
        System.out.println(solution.bestSeqAtIndex(new int[]{
                        2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181
                },
                new int[]{
                        5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594
                }));

        System.out.println(solution.bestSeqAtIndex(new int[]{
                        1, 2, 3, 4
                },
                new int[]{
                        4, 3, 2, 1
                }));
        System.out.println(solution.bestSeqAtIndex(new int[]{
                        65, 70, 56, 75, 60, 68
                },
                new int[]{
                        100, 150, 90, 190, 95, 110
                }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1.现将数据按身高升序，体重降序排列。
         * 2.对体重取最长递增子序列：
         * 1)dp[i]表示长度为i时末尾最小的数是多少
         * 2)如果新数比末尾数大，直接append
         * 3)如果新数没有末尾数大，寻找第一个比新数小的数d[k]，并更新d[k+1] = nums[i]。
         *
         * @param height
         * @param weight
         * @return
         */
        public int bestSeqAtIndex(int[] height, int[] weight) {
            int length = height.length;
            int[][] hws = new int[length][2];
            for (int i = 0; i < length; i++) {
                hws[i] = new int[]{height[i], weight[i]};
            }
            Arrays.sort(hws, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });

            int max = 0;
            int[] dp = new int[length];
            for (int[] hw : hws) {
                int curWeight = hw[1];
                int i = Arrays.binarySearch(dp, 0, max, curWeight);
                if (i < 0) {
                    i = -(i + 1);
                }
                dp[i] = hw[1];
                if (i == max) {
                    ++max;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}