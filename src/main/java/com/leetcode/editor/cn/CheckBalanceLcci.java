package com.leetcode.editor.cn;

//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。 示例 1: 给定二叉树 [3,9,20,nu
//ll,null,15,7]     3    / \   9  20     /  \    15   7 返回 true 。示例 2: 给定二叉树 [1,2,
//2,3,3,null,null,4,4]       1      / \     2   2    / \   3   3  / \ 4   4 返回 fal
//se 。 Related Topics 树 深度优先搜索 
// 👍 50 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class CheckBalanceLcci {
    public static void main(String[] args) {
        Solution solution = new CheckBalanceLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(high(root.left) - high(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        private int high(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHigh = high(root.left);
            int rightHigh = high(root.right);
            return Math.max(leftHigh, rightHigh) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}