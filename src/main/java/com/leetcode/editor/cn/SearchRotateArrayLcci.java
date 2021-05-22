package com.leetcode.editor.cn;

//搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若
//有多个相同元素，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
// 输出: 8（元素5在该数组中的索引）
// 
//
// 示例2: 
//
//  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
// 输出：-1 （没有找到）
// 
//
// 提示: 
//
// 
// arr 长度范围在[1, 1000000]之间 
// 
// Related Topics 数组 二分查找 
// 👍 54 👎 0


public class SearchRotateArrayLcci {
    public static void main(String[] args) {
        Solution solution = new SearchRotateArrayLcci().new Solution();
        System.out.println(solution.search(new int[]{
                1, 1, 1, 1, 1, 2, 1, 1, 1
        }, 2));
        // System.out.println(solution.search(new int[]{
        //         15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
        // }, 5));
        // System.out.println(solution.search(new int[]{
        //         15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
        // }, 11));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] arr, int target) {
            int l = 0;
            int r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (arr[l] == target) {
                    return l;
                } else if (arr[l] == arr[mid]) {
                    l++;
                } else if (arr[l] < arr[mid]) {
                    if (arr[l] > target || arr[mid] < target) {
                        l = mid;
                    } else {
                        l = l + 1;
                        r = mid;
                    }
                } else {
                    if (arr[l] > target && arr[mid] < target) {
                        l = mid;
                    } else {
                        l = l + 1;
                        r = mid;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}