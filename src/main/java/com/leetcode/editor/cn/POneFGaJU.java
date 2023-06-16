//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
// 满足 i != j、i != k 且 j !=k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
// 注意：本题与主站 15 题相同：leetcode.cn/problems/3sum/ 
//
// Related Topics 数组 双指针 排序 👍 115 👎 0


package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：数组中和为 0 的三个数
public class POneFGaJU {
    public static void main(String[] args) {
        Solution solution = new POneFGaJU().new Solution();

        Object ret = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ret);

        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1;
                if (l >= length) {
                    continue;
                }
                int r = length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == 0) {
                        ret.add(toList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        //去重，因为 i不变，当此时 r 取的数的值与前一个相同，所以不用在计算
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ret;
        }

        private List<Integer> toList(int... nums) {
            List<Integer> ret = new ArrayList<>();
            for (int num : nums) {
                ret.add(num);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}