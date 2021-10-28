package com.leetcode.editor.cn;

//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 124 题相同： https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 8 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class JC7MId {
    public static void main(String[] args) {
        Solution solution = new JC7MId().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {

        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            max(root);
            return max;
        }

        private int max(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = Math.max(max(root.left), 0);
            int right = Math.max(max(root.right), 0);
            //left->root->right 作为路径与已经计算过历史最大值做比较
            int cur = left + right + root.val;
            max = Math.max(cur, max);
            // 返回经过root的单边最大分支给当前root的父节点计算使用
            return root.val + Math.max(left, right);


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}