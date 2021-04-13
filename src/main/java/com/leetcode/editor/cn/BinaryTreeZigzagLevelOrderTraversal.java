package com.leetcode.editor.cn;

//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
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
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 435 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            boolean flag = true;
            if (root != null) {
                queue.addLast(root);
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> curRet = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    if (flag) {
                        TreeNode node = queue.pollFirst();
                        curRet.add(node.val);
                        TreeNode left = node.left;
                        TreeNode right = node.right;
                        if (left != null) {
                            queue.addLast(left);
                        }
                        if (right != null) {
                            queue.addLast(right);
                        }
                    } else {
                        TreeNode node = queue.pollLast();
                        curRet.add(node.val);
                        TreeNode left = node.left;
                        TreeNode right = node.right;
                        if (right != null) {
                            queue.addFirst(right);
                        }
                        if (left != null) {
                            queue.addFirst(left);
                        }

                    }
                }
                ret.add(curRet);
                flag = !flag;
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}