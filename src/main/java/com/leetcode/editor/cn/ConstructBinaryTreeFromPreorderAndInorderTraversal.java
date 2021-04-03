package com.leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 970 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> valIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                valIndexMap.put(inorder[i], i);
            }
            return build(preorder, valIndexMap, 0, inorder.length - 1, 0);
        }

        public TreeNode build(int[] preorder, Map<Integer, Integer> valIndexMap, int preStart, int preEnd,
                              int inStart) {
            if (preStart > preEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRootIndex = valIndexMap.get(root.val);
            int len = inRootIndex - inStart;
            root.left = build(preorder, valIndexMap, preStart + 1, preStart + len, inStart);
            root.right = build(preorder, valIndexMap, preStart + len + 1, preEnd, inRootIndex + 1);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}