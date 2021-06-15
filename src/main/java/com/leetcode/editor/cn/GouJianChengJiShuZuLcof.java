package com.leetcode.editor.cn;

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 123 👎 0


public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            //边界条件的判断
            if (a == null || a.length == 0) {
                return a;
            }
            int length = a.length;
            int[] res = new int[length];
            res[0] = 1;
            //当前元素左边的所有元素乘积（不包含当前元素）
            for (int i = 1; i < length; i++) {
                res[i] = res[i - 1] * a[i - 1];
            }
            int right = 1;
            //right表示当前元素右边所有元素的乘积（不包含当前元素）,
            //res[i]表示的是左边的乘积，他俩相乘就是
            //除了自己以外数组的乘积
            for (int i = length - 1; i >= 0; i--) {
                res[i] *= right;
                right *= a[i];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}