package com.leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 564 👎 0


import com.leetcode.editor.cn.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {}
     * TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val;
     * this.left = left; this.right = right; } }
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                if (node == null) {
                    stack.pop();
                    node = stack.pop();
                    ret.add(node.val);
                } else {
                    node = stack.pop();
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    stack.push(node);
                    stack.push(null);
                    if (right != null) {
                        stack.push(right);
                    }
                    if (left != null) {
                        stack.push(left);
                    }

                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}