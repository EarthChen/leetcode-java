package com.leetcode.editor.cn;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列 
// 👍 447 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.addLast(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    if (i == size - 1) {
                        ret.add(node.val);
                    }
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
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}