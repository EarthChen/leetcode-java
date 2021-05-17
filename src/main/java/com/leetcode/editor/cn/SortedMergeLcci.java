package com.leetcode.editor.cn;

//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针 
// 👍 107 👎 0


public class SortedMergeLcci {
    public static void main(String[] args) {
        Solution solution = new SortedMergeLcci().new Solution();
        int[] a = new int[]{1, 2, 3, 0, 0, 0};
        int[] b = new int[]{2, 5, 6};
        // solution.merge(a, 3, b, 3);
        // for (int i : a) {
        //     System.out.println(i);
        // }
        a = new int[]{0};
        b = new int[]{1};
        solution.merge(a, 0, b, 1);
        for (int i : a) {
            System.out.println(i);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] A, int m, int[] B, int n) {
            int i = m - 1;
            int j = n - 1;
            int index = A.length - 1;
            while (i >= 0 && j >= 0) {
                int aNum = A[i];
                int bNum = B[j];
                if (aNum >= bNum) {
                    A[index] = aNum;
                    i--;
                } else {
                    A[index] = bNum;
                    j--;
                }
                index--;
            }
            while (i >= 0) {
                A[index] = A[i];
                i--;
                index--;
            }
            while (j >= 0) {
                A[index] = B[j];
                j--;
                index--;
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}