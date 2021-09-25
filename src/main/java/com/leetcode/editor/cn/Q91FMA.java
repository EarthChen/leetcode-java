package com.leetcode.editor.cn;

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
// 
// 1 <= arr[i] < arr[i + 1] <= 10^9 
// 
// 
//
// 
//
// 注意：本题与主站 873 题相同： https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
// Related Topics 数组 哈希表 动态规划 
// 👍 5 👎 0


import java.util.HashMap;
import java.util.Map;

public class Q91FMA {
    public static void main(String[] args) {
        Solution solution = new Q91FMA().new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution.lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int length = arr.length;
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                indexMap.put(arr[i], i);
            }
            Map<String, Integer> dpMap = new HashMap<>();
            int max = 0;
            for (int i = 2; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    int left = arr[i] - arr[j];
                    Integer findIndex = indexMap.get(left);
                    // 没找到
                    if (findIndex == null) {
                        continue;
                    }
                    // 找到的在当前后面
                    if (findIndex >= j) {
                        continue;
                    }
                    String dpKey = getDpKey(findIndex, j);
                    Integer curMax = dpMap.get(dpKey);
                    if (curMax == null) {
                        curMax = 3;
                    } else {
                        curMax++;
                    }
                    dpMap.put(dpKey, curMax);
                    dpMap.put(getDpKey(j, i), curMax);
                    max = Math.max(max, curMax);
                }
            }
            return max;
        }

        private String getDpKey(int i, int j) {
            return i + "" + j;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}