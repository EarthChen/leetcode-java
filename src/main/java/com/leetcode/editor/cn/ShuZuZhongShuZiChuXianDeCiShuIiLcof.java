package com.leetcode.editor.cn;

//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 191 👎 0


public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            return findOnce(nums, 3);
        }

        // n是出现的次数
        public int findOnce(int[] nums, int n) {
            int bitLength = 32;
            int res = 0;
            for (int i = 0; i < bitLength; i++) {
                int oneCount = 0;
                for (int num : nums) {
                    oneCount += (num >>> i) & 1;
                }
                if (oneCount % n != 0) {
                    res |= (1 << i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}