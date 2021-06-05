package com.leetcode.editor.cn;

//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 242 👎 0


public class VolumeOfHistogramLcci {
    public static void main(String[] args) {
        Solution solution = new VolumeOfHistogramLcci().new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution.trap(new int[]{4, 2, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int high = 0;
            int i = 0;
            int j = height.length - 1;
            int ret = 0;
            while (i <= j) {
                while (i < height.length) {
                    if (height[i] > high) {
                        break;
                    }
                    i++;
                }
                while (j >= 0) {
                    if (height[j] > high) {
                        break;
                    }
                    j--;
                }
                if (i >= height.length || j <= 0) {
                    break;
                }

                int min = Math.min(height[i], height[j]);
                for (int k = i + 1; k < j; k++) {
                    if (height[k] < min) {
                        ret += min - height[k];
                        height[k] = min;
                    }
                }
                high = min;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}