package com.leetcode.editor.cn;

//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层序遍历为：
//
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 426 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            levelOrderBottom(root, 0);
            return res;
        }

        public void levelOrderBottom(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (res.size() <= level) {
                res.add(0, new ArrayList<>());
            }
            res.get(res.size() - level - 1).add(root.val);
            levelOrderBottom(root.left, level + 1);
            levelOrderBottom(root.right, level + 1);
        }
        // List<List<Integer>> ret = new ArrayList<>();
        // LinkedList<TreeNode> queue = new LinkedList<>();
        // if (root != null) {
        //     queue.push(root);
        // }
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     List<Integer> vals = new ArrayList<>();
        //     for (int i = 0; i < size; i++) {
        //         TreeNode cur = queue.pollLast();
        //         vals.add(cur.val);
        //         TreeNode left = cur.left;
        //         TreeNode right = cur.right;
        //         if (left != null) {
        //             queue.push(left);
        //         }
        //         if (right != null) {
        //             queue.push(right);
        //         }
        //     }
        //     ret.add(0, vals);
        // }
        // return ret;
    }
    //leetcode submit region end(Prohibit modification and deletion)

}

