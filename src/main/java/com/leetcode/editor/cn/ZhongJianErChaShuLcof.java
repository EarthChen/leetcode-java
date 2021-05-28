package com.leetcode.editor.cn;

//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 458 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> valIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                valIndexMap.put(inorder[i], i);
            }
            return build(preorder, valIndexMap, 0, preorder.length - 1, 0);
        }

        private TreeNode build(int[] preorder,
                               Map<Integer, Integer> valIndexMap,
                               int preStart,
                               int preEnd,
                               int start
        ) {
            if (preStart > preEnd) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preStart]);
            int inRootIndex = valIndexMap.get(root.val);
            int len = inRootIndex - start;
            root.left = build(preorder, valIndexMap, preStart + 1, preStart + len, start);
            root.right = build(preorder, valIndexMap, preStart + len + 1, preEnd, inRootIndex + 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}