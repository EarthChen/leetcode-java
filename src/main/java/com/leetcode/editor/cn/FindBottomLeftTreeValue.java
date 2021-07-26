package com.leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 190 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.LinkedList;

public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            Integer val = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                val = queue.peekFirst().val;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (left != null) {
                        queue.addLast(left);
                    }
                    if (right != null) {
                        queue.addLast(right);
                    }
                }
            }
            return val;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}