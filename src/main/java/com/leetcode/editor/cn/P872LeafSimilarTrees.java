//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,
//null,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树结点数在 [1, 200] 范围内 
// 给定的两棵树上的值在 [0, 200] 范围内 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 184 👎 0


package com.leetcode.editor.cn;

import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

//Java：叶子相似的树
public class P872LeafSimilarTrees {
    public static void main(String[] args) {
        Solution solution = new P872LeafSimilarTrees().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        private LinkedList<Integer> list1 = new LinkedList<>();

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            dfs(root1, list1);
            dfs(root2, list2);
            if (list1.size() != list2.size()) {
                return false;
            }
            for (int i = 0; i < list1.size(); i++) {
                if (!Objects.equals(list1.get(i), list2.get(i))) {
                    return false;
                }
            }
            return true;
        }

        private void dfs(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}