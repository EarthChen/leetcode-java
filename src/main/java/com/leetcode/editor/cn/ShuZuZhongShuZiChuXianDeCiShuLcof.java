package com.leetcode.editor.cn;

//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 408 👎 0


public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            //用于将所有的数异或起来
            int k = 0;

            for (int num : nums) {
                k ^= num;
            }

            //获得k中最低位的1
            int mask = 1;

            //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
            while ((k & mask) == 0) {
                mask <<= 1;
            }

            int a = 0;
            int b = 0;

            for (int num : nums) {
                if ((num & mask) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }

            return new int[]{a, b};

            // Map<Integer, Integer> map = new HashMap<>();
            // for (int num : nums) {
            //     map.put(num, map.getOrDefault(num, 0) + 1);
            // }
            // int[] ans = new int[2];
            // int i = 0;
            // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //     if (entry.getValue() == 1) {
            //         ans[i] = entry.getKey();
            //         if (i == 1) {
            //             break;
            //         }
            //         i++;
            //     }
            // }
            // return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}