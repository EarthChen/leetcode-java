//如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的： 
//
// 
// n >= 3 
// 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2} 
// 
//
// 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。如果一个不存在，返回 0 。 
//
// （回想一下，子序列是从原序列 arr 中派生出来的，它从 arr 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 
//是 [3, 4, 5, 6, 7, 8] 的一个子序列） 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入: arr = [1,2,3,4,5,6,7,8]
//输出: 5
//解释: 最长的斐波那契式子序列为 [1,2,3,5,8] 。
// 
//
// 示例 2： 
//
// 
//输入: arr = [1,3,7,11,12,14,18]
//输出: 3
//解释: 最长的斐波那契式子序列有 [1,11,12]、[3,11,14] 以及 [7,11,18] 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= arr.length <= 1000 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
//
// 
//
// 
// 注意：本题与主站 873 题相同： https://leetcode-cn.com/problems/length-of-longest-
//fibonacci-subsequence/ 
//
// Related Topics 数组 哈希表 动态规划 👍 60 👎 0


package com.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长斐波那契数列
public class PQ91FMAQ91FMA {
    public static void main(String[] args) {
        Solution solution = new PQ91FMAQ91FMA().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            Map<Integer, Integer> arrIndexMap = new HashMap<>();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                arrIndexMap.put(arr[i], i);
            }
            int[][] dp = new int[len][len];
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--) {
                    int val = arr[i] - arr[j];
                    int k = arrIndexMap.getOrDefault(val, -1);
                    if (k >= 0) {
                        dp[j][i] = Math.max(dp[k][j] + 1, 3);
                    }
                    max = Math.max(max, dp[j][i]);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}