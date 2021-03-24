package com.leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 817 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.push(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> vals = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollLast();
                    vals.add(cur.val);
                    TreeNode left = cur.left;
                    TreeNode right = cur.right;
                    if (left != null) {
                        queue.push(left);
                    }
                    if (right != null) {
                        queue.push(right);
                    }
                }
                ret.add(vals);
            }
            return ret;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}