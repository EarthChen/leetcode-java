package com.leetcode.editor.cn;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 👍 898 👎 0


import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int high = triangle.size();
            int[] minArr = new int[high];
            int[] curMinArr = new int[high];
            int min = triangle.get(0).get(0);
            minArr[0] = min;
            for (int i = 1; i < high; i++) {
                List<Integer> list = triangle.get(i);
                int curMin = Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    if (j == 0) {
                        curMinArr[j] = minArr[j] + list.get(j);
                    } else if (j == list.size() - 1) {
                        curMinArr[j] = minArr[j - 1] + list.get(j);
                    } else {
                        int lastMin = Math.min(minArr[j - 1], minArr[j]);
                        curMinArr[j] = lastMin + list.get(j);
                    }
                    curMin = Math.min(curMin, curMinArr[j]);
                }
                System.arraycopy(curMinArr, 0, minArr, 0, curMinArr.length);
                min = curMin;
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}