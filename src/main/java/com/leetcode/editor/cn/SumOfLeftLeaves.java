package com.leetcode.editor.cn;

//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 297 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return sum(root, false);
        }

        private int sum(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (isLeft && left == null && right == null) {
                return root.val;
            }
            return sum(left, true) + sum(right, false);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}