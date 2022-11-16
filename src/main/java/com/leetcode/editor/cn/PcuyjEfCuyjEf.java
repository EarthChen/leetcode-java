//给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 
//i 的概率与 w[i] 成正比。 
//
// 
// 
//
// 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 +
// 3) = 0.75（即，75%）。 
//
// 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//inputs = ["Solution","pickIndex"]
//inputs = [[[1]],[]]
//输出：
//[null,0]
//解释：
//Solution solution = new Solution([1]);
//solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。 
//
// 示例 2： 
//
// 
//输入：
//inputs = ["Solution","pickIndex","pickIndex","pickIndex","pickIndex",
//"pickIndex"]
//inputs = [[[1,3]],[],[],[],[],[]]
//输出：
//[null,1,1,1,1,0]
//解释：
//Solution solution = new Solution([1, 3]);
//solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 1
//solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
//
//由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
//[null,1,1,1,1,0]
//[null,1,1,1,1,1]
//[null,1,1,1,0,0]
//[null,1,1,1,0,1]
//[null,1,0,1,0,0]
//......
//诸若此类。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= w.length <= 10000 
// 1 <= w[i] <= 10^5 
// pickIndex 将被调用不超过 10000 次 
// 
//
// 
//
// 
// 注意：本题与主站 528 题相同： https://leetcode-cn.com/problems/random-pick-with-weight/ 
//
// Related Topics 数学 二分查找 前缀和 随机化 👍 37 👎 0


package com.leetcode.editor.cn;

import java.util.Random;

//Java：按权重生成随机数
public class PcuyjEfCuyjEf {
    public static void main(String[] args) {
        // Solution solution = new PcuyjEfCuyjEf().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] w;
        private int sum;
        private Random random = new Random();// 生成随机数

        public Solution(int[] w) {
            this.w = w;
            // 计算前缀和
            for (int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            sum = w[w.length - 1];//所有权重的和
        }

        public int pickIndex() {// 二分查找
            int target = random.nextInt(sum) + 1;// 生成[1,sum]范围的随机数。nextInt(n)生成[0,n)的随机数
            int left = 0;
            int right = w.length - 1;
            while (left <= right) {// 闭区间二分查找
                int mid = (left + right) / 2;
                if (w[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;// 返回下标
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
//leetcode submit region end(Prohibit modification and deletion)

}