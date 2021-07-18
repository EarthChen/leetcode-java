package com.leetcode.editor.cn;

//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
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
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 
// 👍 815 👎 0


import java.util.LinkedList;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        // int[] ans = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        int[] ans = solution.dailyTemperatures(new int[]{30,40,50,60});
        for (int an : ans) {
            System.out.print(an + ",");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            LinkedList<Integer> stack = new LinkedList<>();
            int length = temperatures.length;
            int[] ans = new int[length];
            for (int i = 0; i < length; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    continue;
                }
                int curVal = temperatures[i];
                int topIndex = stack.peek();
                int topVal = temperatures[topIndex];
                while (curVal > topVal) {
                    ans[topIndex] = i - topIndex;
                    stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    topIndex = stack.peek();
                    topVal = temperatures[topIndex];
                }
                stack.push(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}