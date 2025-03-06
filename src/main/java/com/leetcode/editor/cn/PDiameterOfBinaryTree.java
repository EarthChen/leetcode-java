//给你一棵二叉树的根节点，返回该树的 直径 。 
//
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。 
//
// 两节点之间路径的 长度 由它们之间边数表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1672 👎 0


package com.leetcode.editor.cn;

//Java：二叉树的直径
public class PDiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new PDiameterOfBinaryTree().new Solution();
        // TO TEST
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {

        int maxd = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxd;
        }


        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = dfs(root.left);
            int r = dfs(root.right);
            maxd = Math.max(l + r, maxd);
            return Math.max(l, r) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}