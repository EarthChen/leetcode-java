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
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] tailOrder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(preorder, inorder);
        TreeNode root2 = solution.buildTailTree(tailOrder, inorder);
        TreeNode root3 = solution.buildTailTree(tailOrder, inorder);
        System.out.println();
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

        public TreeNode buildTailTree(int[] tailOrder, int[] inorder) {
            Map<Integer, Integer> valIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                valIndexMap.put(inorder[i], i);
            }
            return buildTail(tailOrder, valIndexMap, 0, tailOrder.length - 1, 0);
        }

        public TreeNode buildTailTree2(int[] tailOrder, int[] inorder) {
            Map<Integer, Integer> valIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                valIndexMap.put(inorder[i], i);
            }
            return buildTail2(tailOrder, valIndexMap, 0, tailOrder.length - 1, 0);
        }


        /**
         * 后续、中序构造二叉树
         * 从前边开始计算长度(左子树)
         */
        public TreeNode buildTail(int[] postorder, Map<Integer, Integer> map, int postStart, int postEnd,
                                  int inStart) {
            if (postEnd < postStart) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postEnd]);
            int inRootIndex = map.get(root.val);
            /**
             * 左子树长度
             */
            int len = inRootIndex - inStart;
            root.left = buildTail(postorder, map, postStart, postStart + len - 1, inStart);
            root.right = buildTail(postorder, map, postStart + len, postEnd - 1, inRootIndex + 1);
            return root;
        }

        /**
         * 后续、中序构造二叉树
         * 从右边开始计算长度(右子树)
         */
        public TreeNode buildTail2(int[] postorder, Map<Integer, Integer> map, int postStart, int postEnd,
                                   int inEnd) {
            if (postEnd < postStart) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postEnd]);
            int inRootIndex = map.get(root.val);
            /**
             * 右子树长度
             */
            int len = inEnd - inRootIndex;
            root.left = buildTail2(postorder, map, postStart, postEnd - len - 1, inEnd - 1);
            root.right = buildTail2(postorder, map, postEnd - len, postEnd - 1, len);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}