//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。 
//
// 不占用额外内存空间能否做到？ 
//
// 
//
// 示例 1： 
//
// 
//给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2： 
//
// 
//给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
//
// 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/ 
//
// Related Topics 数组 数学 矩阵 👍 299 👎 0


package com.leetcode.editor.cn;

//Java：旋转矩阵
public class PRotateMatrixLcci {
    public static void main(String[] args) {
        Solution solution = new PRotateMatrixLcci().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            while (top < bottom && left < right) {

                for (int i = 0; i < right - left; i++) {
                    int temp = matrix[top][left + i];
                    matrix[top][left + i] = matrix[bottom - i][left];
                    matrix[bottom - i][left] = matrix[bottom][right - i];
                    matrix[bottom][right - i] = matrix[top + i][right];
                    matrix[top + i][right] = temp;
                }
                top++;
                bottom--;
                left++;
                right--;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}