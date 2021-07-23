package com.leetcode.editor.cn;

//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 535 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inorderValIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderValIndexMap.put(inorder[i], i);
            }
            return build(inorderValIndexMap, postorder, 0, postorder.length - 1, 0);
        }

        private TreeNode build(Map<Integer, Integer> inorderValIndexMap,
                               int[] postorder,
                               int postStart,
                               int postEnd,
                               int inOrderStart) {
            if (postEnd < postStart) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postEnd]);
            int index = inorderValIndexMap.get(root.val);
            int leftLen = index - inOrderStart;
            root.left = build(inorderValIndexMap, postorder, postStart, postStart+leftLen-1, inOrderStart);
            root.right = build(inorderValIndexMap, postorder, postStart+leftLen, postEnd-1, index+1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}