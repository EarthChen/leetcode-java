//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1490 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的层序遍历
public class P102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; } }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root != null) {
                stack.addLast(root);
            }
            while (!stack.isEmpty()) {
                int size = stack.size();
                List<Integer> curRet = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack.pollFirst();
                    curRet.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if (left != null) {
                        stack.addLast(left);
                    }
                    if (right != null) {
                        stack.addLast(right);
                    }
                }
                ret.add(curRet);
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}