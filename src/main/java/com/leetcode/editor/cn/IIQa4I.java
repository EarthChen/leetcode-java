package com.leetcode.editor.cn;

//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
// Related Topics 栈 数组 单调栈 👍 13 👎 0


import java.util.LinkedList;

public class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
        // int[] ans = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] ans = solution.dailyTemperatures(new int[]{30,40,50,60});
        for (int an : ans) {
            System.out.print(an);
            System.out.print(",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            LinkedList<Integer> stack = new LinkedList<>();
            int length = temperatures.length;
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        int topIndex = stack.peekLast();
                        if (temperatures[topIndex] < temperatures[i]) {
                            ans[topIndex] = i - topIndex;
                            stack.pollLast();
                        } else {
                            break;
                        }
                    }
                }
                stack.addLast(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}