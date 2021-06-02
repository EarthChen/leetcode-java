package com.leetcode.editor.cn;

//给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","
//L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
// Related Topics 数组 
// 👍 36 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLcci {
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
        String[] ans = solution.findLongestSubarray(new String[]{
                "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"
        });
        solution.findLongestSubarray(ans);

        System.out.println();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findLongestSubarray(String[] array) {
            int n = array.length;
            int[] sum = new int[n];
            for (int i = 0; i < array.length; i++) {
                String s = array[i];
                //数字可能是 42 19 这样的
                if (s.compareTo("A") >= 0 && s.compareTo("z") <= 0) {
                    sum[i] = -1;
                } else {
                    sum[i] = 1;
                }
            }
            for (int i = 1; i < n; i++) {
                sum[i] += sum[i - 1];
            }
            int l = -1, r = -1;
            //记录当前值的最左侧的下标
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (sum[i] == 0) {//为0的情况
                    if (r - l + 1 < i + 1) {
                        r = i;
                        l = 0;
                    }
                    continue;
                }
                //记录下第一次出现的数字的最左侧的下标
                if (!map.containsKey(sum[i])) {
                    map.put(sum[i], i);
                } else {
                    if (r - l + 1 < i - map.get(sum[i])) {
                        r = i;
                        l = map.get(sum[i]) + 1;
                    }
                }
            }
            if (l == -1 && r == -1) {
                return new String[]{};
            }
            return Arrays.copyOfRange(array, l, r + 1);//取头不取尾
        }

        private boolean isNumber(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}