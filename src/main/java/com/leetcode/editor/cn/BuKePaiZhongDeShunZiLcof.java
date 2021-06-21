package com.leetcode.editor.cn;

//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 140 👎 0


import java.util.Arrays;

public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        System.out.println(solution.isStraight(new int[]{1,2,3,4,5}));
        System.out.println(solution.isStraight(new int[]{0,0,1,2,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int length = nums.length;
            int i = 0;
            int count = 0;
            while (i < length) {
                if (nums[i] != 0) {
                    break;
                }
                count++;
                i++;
            }
            while (i + 1 < length) {
                int cha = nums[i + 1] - nums[i];
                if (cha == 1) {
                    i++;
                } else if (cha == 0) {
                    return false;
                } else {
                    count = count - (cha -1);
                    if (count < 0) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}