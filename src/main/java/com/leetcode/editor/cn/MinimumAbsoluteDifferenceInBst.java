package com.leetcode.editor.cn;

//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 
// 👍 263 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {

        private List<Integer> ans = new ArrayList<>();

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < ans.size(); i++) {
                min = Math.min(min, ans.get(i) - ans.get(i - 1));
            }
            return min;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            ans.add(root.val);
            dfs(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}