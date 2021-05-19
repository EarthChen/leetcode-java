package com.leetcode.editor.cn;

//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 73 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

public class BinodeLcci {
    public static void main(String[] args) {
        Solution solution = new BinodeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int
     * x) { val = x; } }
     */
    class Solution {
        TreeNode pre = new TreeNode(0);
        TreeNode cur = pre;

        public TreeNode convertBiNode(TreeNode root) {
            inorder(root);
            return pre.right;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            cur.right = root;
            root.left = null;
            cur = root;
            inorder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}