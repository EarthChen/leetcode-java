package com.leetcode.editor.cn;

//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。 
//
// 如果指定节点没有对应的“下一个”节点，则返回null。 
//
// 示例 1: 
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /   
//1
//
//输出: null 
// Related Topics 树 深度优先搜索 
// 👍 58 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
        TreeNode node = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        node.left = left;
        node.right = right;
        TreeNode ret = solution.inorderSuccessor(node, left);
        System.out.println(ret);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {

        private TreeNode last = null;
        private TreeNode ans = null;

        private void inorder(TreeNode root, TreeNode p) {
            if (p == null) {
                return;
            }
            if (root == null) {
                return;
            }
            inorder(root.left, p);
            if (last == p) {
                ans = root;
            }
            last = root;
            inorder(root.right, p);
        }

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

            inorder(root, p);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}